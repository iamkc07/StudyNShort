package com.example.studynshort;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class QuizOptionActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    private TextView question, noIndicator;

    RelativeLayout optionContainer;

    List<QuizOptionModel> QList;

    private  int position = 0;
    private Button btnNext;

    private int count = 0;

    private int score = 0;

    ProgressBar progressBar;

    private String title, no;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_option);

        question = findViewById(R.id.question);
        noIndicator = findViewById(R.id.outofQ);
        optionContainer = findViewById(R.id.optionContainer);
        btnNext = findViewById(R.id.nextbtn);
        progressBar = findViewById(R.id.loading);

        QList = new ArrayList<>();



        title = getIntent().getStringExtra("title");



        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Window window = this.getWindow();
            window.setStatusBarColor(this.getResources().getColor(R.color.light_blue));
        }



        progressBar.setVisibility(View.VISIBLE);
        myRef.child("Quiz").child(title).child("questions").orderByChild("no").equalTo(title).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    QList.add(dataSnapshot.getValue(QuizOptionModel.class));
                }
                if (QList.size() > 0){

                    for(int i = 0; i <4; i++){
                        optionContainer.getChildAt(i).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                checkAnswer((Button) v);
                            }
                        });
                    }

                    playAnimation(question, 0, QList.get(position).getQuestion());
                    btnNext.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            btnNext.setEnabled(false);
                            btnNext.setAlpha(0.7f);
                            enableoption(true);
                            position++;
                            if (position == QList.size()){
                                Intent scoreIntent = new Intent(QuizOptionActivity.this, QuizResultActivity.class);
                                scoreIntent.putExtra("score", score);
                                scoreIntent.putExtra("total", QList.size());
                                startActivity(scoreIntent);
                                finish();
                                return;
                            }
                            count = 0;
                            playAnimation(question,0, QList.get(position).getQuestion());
                        }

                    });
                }else {

                    finish();
                    Toast.makeText(QuizOptionActivity.this, "No Question", Toast.LENGTH_SHORT).show();
                }
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(QuizOptionActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
                finish();
            }
        });


    }

    private void playAnimation(View view,  int value, final String data){
        view.animate().alpha(value).scaleX(value).scaleY(value).setDuration(300).setStartDelay(100).setInterpolator(new DecelerateInterpolator()).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(@NonNull Animator animation) {
                if(value == 0 && count < 4){
                    String option = "";
                    if (count == 0){
                        option = QList.get(position).getOptionA();
                    } else if (count == 1) {
                        option = QList.get(position).getOptionB();
                    } else if (count == 2) {
                        option = QList.get(position).getOptionC();
                    } else if (count == 3) {
                        option = QList.get(position).getOptionD();
                    }
                    playAnimation(optionContainer.getChildAt(count), 0, option);
                    count++;
                }
            }

            @Override
            public void onAnimationEnd(@NonNull Animator animation) {

                if(value == 0){
                    try {
                        ((TextView)view).setText(data);
                        noIndicator.setText(position+1+"/"+QList.size());
                    } catch (ClassCastException e){
                        ((Button)view).setText(data);
                    }
                    view.setTag(data);
                    playAnimation(view,1, data);
                }
            }

            @Override
            public void onAnimationCancel(@NonNull Animator animation) {

            }

            @Override
            public void onAnimationRepeat(@NonNull Animator animation) {

            }
        });
    }

    private void checkAnswer( Button selectOption){
        enableoption(false);
        btnNext.setEnabled(true);
        btnNext.setAlpha(1);
        if ( selectOption.getText().toString().equals(QList.get(position).getCorrectAns())){
            //CorrectAns
            score++;
            selectOption.setBackgroundResource(R.drawable.correct_option);
        } else {
            //Incorrect
            selectOption.setBackgroundResource(R.drawable.wrong_option);
            Button correctAns = (Button) optionContainer.findViewWithTag(QList.get(position).getCorrectAns());
            correctAns.setBackgroundResource(R.drawable.correct_option);
        }
    }



    private void enableoption( boolean enable){
        for(int i = 0; i <4; i++) {
            optionContainer.getChildAt(i).setEnabled(enable);
            if (enable){
                optionContainer.getChildAt(i).setBackgroundResource(R.drawable.option_box);
            }
        }
    }

}