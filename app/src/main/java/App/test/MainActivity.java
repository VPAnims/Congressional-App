package App.test;

import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import App.test.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private CalendarView calandar;
    private ImageView FoodImage;
    private ImageView ExerciseImage;
    private ImageView ScreenImage;
    private ImageView MeditatingImage;
    private LinearLayout linearLayout;
    private TextView invisText1;
    private Button HabitsButton;
    private Button NewHabitButton;
    private Spinner pickHabit;
    private Button FinishButton;
    private Boolean FoodTrue = false;
    private Boolean ExerciseTrue = false;
    private Boolean ScreenTrue = false;
    private Boolean MeditatingTrue = false;
    private Boolean NoneTrue = true;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.layout);
        FoodImage = findViewById(R.id.Food);
        ExerciseImage = findViewById(R.id.Exercise);
        ScreenImage = findViewById(R.id.screenTime);
        MeditatingImage = findViewById(R.id.Meditating);
        calandar = findViewById(R.id.calendarView);
        invisText1 = findViewById(R.id.CreateText);
        HabitsButton = findViewById(R.id.button);
        NewHabitButton = findViewById(R.id.NextPageButton);
        FinishButton = findViewById(R.id.finishAdding);
        pickHabit = findViewById(R.id.pickHabit);
        pickHabit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String item = adapterView.getItemAtPosition(position).toString();
                String Choice;
                Choice = item;
                if(Choice == "None"){
                    FinishButton.setVisibility(View.INVISIBLE);
                    MeditatingImage.setVisibility(View.INVISIBLE);
                    FoodImage.setVisibility(View.INVISIBLE);
                    ScreenImage.setVisibility(View.INVISIBLE);
                    ExerciseImage.setVisibility(View.INVISIBLE);
                    FoodTrue = false;
                    ExerciseTrue = false;
                    ScreenTrue = false;
                    MeditatingTrue = false;
                    NoneTrue = true;
                }
                else{
                    NoneTrue = false;
                    FinishButton.setVisibility(View.VISIBLE);
                }
                if(Choice == "Eating Healthy"){
                    MeditatingImage.setVisibility(View.INVISIBLE);
                    FoodImage.setVisibility(View.VISIBLE);
                    ScreenImage.setVisibility(View.INVISIBLE);
                    ExerciseImage.setVisibility(View.INVISIBLE);
                    FoodTrue = true;
                    ExerciseTrue = false;
                    ScreenTrue = false;
                    MeditatingTrue = false;
                }
                if(Choice == "Exercising Everyday"){
                    MeditatingImage.setVisibility(View.INVISIBLE);
                    FoodImage.setVisibility(View.INVISIBLE);
                    ScreenImage.setVisibility(View.INVISIBLE);
                    ExerciseImage.setVisibility(View.VISIBLE);
                    FoodTrue = false;
                    ExerciseTrue = true;
                    ScreenTrue = false;
                    MeditatingTrue = false;
                }
                if(Choice == "Meditating"){
                    MeditatingImage.setVisibility(View.VISIBLE);
                    FoodImage.setVisibility(View.INVISIBLE);
                    ScreenImage.setVisibility(View.INVISIBLE);
                    ExerciseImage.setVisibility(View.INVISIBLE);
                    FoodTrue = false;
                    ExerciseTrue = false;
                    ScreenTrue = false;
                    MeditatingTrue = true;
                }
                if(Choice == "Limiting Screen Time"){
                    MeditatingImage.setVisibility(View.INVISIBLE);
                    FoodImage.setVisibility(View.INVISIBLE);
                    ScreenImage.setVisibility(View.VISIBLE);
                    ExerciseImage.setVisibility(View.INVISIBLE);
                    FoodTrue = false;
                    ExerciseTrue = false;
                    ScreenTrue = true;
                    MeditatingTrue = false;
                }

                //Toast.makeText(MainActivity.this, "Selected: " + item, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                FinishButton.setVisibility(View.INVISIBLE);
            }
        });
        ArrayList<String> habits = new ArrayList<>();
        habits.add("None");
        habits.add("Eating Healthy");
        habits.add("Exercising Everyday");
        habits.add("Meditating");
        habits.add("Limiting Screen Time");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, habits);
        adapter.setDropDownViewResource(android.R.layout.select_dialog_singlechoice);
        pickHabit.setAdapter(adapter);
    }

    public void NextPage(View view){
        linearLayout.setVisibility(View.INVISIBLE);
        invisText1.setVisibility(View.VISIBLE);
        HabitsButton.setVisibility(View.INVISIBLE);
        pickHabit.setVisibility(View.VISIBLE);
        NewHabitButton.setVisibility(View.GONE);
    }
    public void CreatedButtonClicked() {
        calandar.setVisibility(View.VISIBLE);
        linearLayout.setVisibility(View.INVISIBLE);
        invisText1.setVisibility(View.INVISIBLE);
        HabitsButton.setVisibility(View.INVISIBLE);
        pickHabit.setVisibility(View.INVISIBLE);
        NewHabitButton.setVisibility(View.INVISIBLE);
        FinishButton.setVisibility(View.INVISIBLE);
        MeditatingImage.setVisibility(View.INVISIBLE);
        FoodImage.setVisibility(View.INVISIBLE);
        ScreenImage.setVisibility(View.INVISIBLE);
        ExerciseImage.setVisibility(View.INVISIBLE);
    }

     public void PreviousPage(View view){
        linearLayout.setVisibility(View.VISIBLE);
        invisText1.setVisibility(View.INVISIBLE);
        HabitsButton.setVisibility(View.VISIBLE);
        pickHabit.setVisibility(View.INVISIBLE);
        NewHabitButton.setVisibility(View.VISIBLE);
        FinishButton.setVisibility(View.INVISIBLE);
        MeditatingImage.setVisibility(View.INVISIBLE);
        FoodImage.setVisibility(View.INVISIBLE);
        ScreenImage.setVisibility(View.INVISIBLE);
        ExerciseImage.setVisibility(View.INVISIBLE);
    }
    public void CreateHabit(View view){
        linearLayout.setVisibility(View.VISIBLE);
        if(FoodTrue == true){
            Button foodbutton = new Button(this);
            foodbutton.setText("Eating Healthy");
            foodbutton.setBackgroundColor(Color.parseColor("#FFC105"));
            foodbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Eating Healthy", Toast.LENGTH_SHORT).show();
                    CreatedButtonClicked();
                }
            });
            linearLayout.addView(foodbutton);
        }
        else if(ScreenTrue == true){
            Button screenbutton = new Button(this);
            screenbutton.setText("Limit Screen Time");
            screenbutton.setBackgroundColor(Color.parseColor("#FFC105"));
            screenbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Limit Screen Time", Toast.LENGTH_SHORT).show();
                }
            });
            linearLayout.addView(screenbutton);
        }
        else if(MeditatingTrue == true){
            Button mbutton = new Button(this);
            mbutton.setText("Meditating");
            linearLayout.addView(mbutton);
            mbutton.setBackgroundColor(Color.parseColor("#FFC105"));
            mbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Meditating Everyday", Toast.LENGTH_SHORT).show();
                }
            });
        }
        else if(ExerciseTrue == true){
            Button ebutton = new Button(this);
            ebutton.setText("Exercising Everyday");
            ebutton.setBackgroundColor(Color.parseColor("#FFC105"));
            ebutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getApplicationContext(), "Exercising Everyday", Toast.LENGTH_SHORT).show();
                }
            });
            linearLayout.addView(ebutton);
        }


        invisText1.setVisibility(View.INVISIBLE);
        HabitsButton.setVisibility(View.VISIBLE);
        pickHabit.setVisibility(View.INVISIBLE);
        NewHabitButton.setVisibility(View.VISIBLE);
        FinishButton.setVisibility(View.INVISIBLE);
        MeditatingImage.setVisibility(View.INVISIBLE);
        FoodImage.setVisibility(View.INVISIBLE);
        ScreenImage.setVisibility(View.INVISIBLE);
        ExerciseImage.setVisibility(View.INVISIBLE);
    }

}