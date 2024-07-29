package App.test;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import App.test.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ImageView FoodImage;
    private ImageView ExerciseImage;
    private ImageView ScreenImage;
    private ImageView MeditatingImage;
    private TextView text;
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
        text = findViewById(R.id.Text);
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

                }
                if(Choice == "Exercising Everyday"){
                    MeditatingImage.setVisibility(View.INVISIBLE);
                    FoodImage.setVisibility(View.INVISIBLE);
                    ScreenImage.setVisibility(View.INVISIBLE);
                    ExerciseImage.setVisibility(View.VISIBLE);
                    FoodTrue = false;

                }
                if(Choice == "Meditating"){
                    MeditatingImage.setVisibility(View.VISIBLE);
                    FoodImage.setVisibility(View.INVISIBLE);
                    ScreenImage.setVisibility(View.INVISIBLE);
                    ExerciseImage.setVisibility(View.INVISIBLE);
                    FoodTrue = false;

                }
                if(Choice == "Limiting Screen Time"){
                    MeditatingImage.setVisibility(View.INVISIBLE);
                    FoodImage.setVisibility(View.INVISIBLE);
                    ScreenImage.setVisibility(View.VISIBLE);
                    ExerciseImage.setVisibility(View.INVISIBLE);
                    FoodTrue = false;

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
    public void buttonNext(View view){
        text.setText("◄");
    }
    public void NextPage(View view){
        invisText1.setVisibility(View.VISIBLE);
        text.setVisibility(View.INVISIBLE);
        HabitsButton.setVisibility(View.INVISIBLE);
        pickHabit.setVisibility(View.VISIBLE);
        NewHabitButton.setVisibility(View.GONE);
    }

     public void PreviousPage(View view){
        invisText1.setVisibility(View.INVISIBLE);
        text.setVisibility(View.VISIBLE);
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
        Button button = new Button(this);
        if(FoodTrue = true){
            button.setText("Eating Healthy");
        }
        linearLayout.addView(button);
        if(NoneTrue = true){
            linearLayout.removeView(button);
        }
        invisText1.setVisibility(View.INVISIBLE);
        text.setVisibility(View.VISIBLE);
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