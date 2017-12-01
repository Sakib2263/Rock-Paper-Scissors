package comsitecsedusakibhasan.google.httpssites.rockpaperscissor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static android.content.Intent.FLAG_ACTIVITY_NO_HISTORY;

public class MainActivity extends AppCompatActivity {


    Button rock,paper,scissors;
    ImageView img_user, img_cpu;
    TextView CpuScore,userScore,Round;

    String myTurn, cpuTurn, result;
    int count1 = 0, count2 = 0, round= 0;
    Random r;
    Toast toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_cpu = (ImageView) findViewById(R.id.img_cpu);
        img_user = (ImageView) findViewById(R.id.img_user);

        rock = (Button) findViewById(R.id.rock);
        paper = (Button) findViewById(R.id.paper);
        scissors = (Button) findViewById(R.id.scissors);

        CpuScore = (TextView) findViewById(R.id.CpuScore);
        userScore = (TextView) findViewById(R.id.userScore);
        Round = (TextView) findViewById(R.id.Round);


        r = new Random();

        rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myTurn = "rock";
                img_user.setImageResource(R.drawable.rock);
                Count();
            }
        });
        paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myTurn = "paper";
                img_user.setImageResource(R.drawable.paper);
                Count();
            }
        });
        scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myTurn = "scissors";
                img_user.setImageResource(R.drawable.scissors);
                Count();
            }
        });
    }
    public void Count(){
        int cpu = r.nextInt(3);
        if(cpu == 0 ){
            cpuTurn = "rock";
            img_cpu.setImageResource(R.drawable.rock2);
        }
        if(cpu == 1 ){
            cpuTurn = "paper";
            img_cpu.setImageResource(R.drawable.paper2);
        }
        if(cpu == 2 ){
            cpuTurn = "scissors";
            img_cpu.setImageResource(R.drawable.scissors2);
        }
        if(myTurn.equals(cpuTurn)){
            result = "draw";
        }
        else {
            if (myTurn.equals("rock") && cpuTurn.equals("paper")) {
                result = "You Lose";
                count2++;
            }
            else if (myTurn.equals("paper") && cpuTurn.equals("scissors")) {
                result = "You Lose";
                count2++;
            }
            else if (myTurn.equals("scissors") && cpuTurn.equals("rock")) {
                result = "You Lose";
                count2++;
            }
            else if (myTurn.equals("rock") && cpuTurn.equals("scissors")) {
                result = "You Win";
                count1++;
            }

            else if (myTurn.equals("paper") && cpuTurn.equals("rock")) {
                result = "You Win";
                count1++;
            }
            else if (myTurn.equals("scissors") && cpuTurn.equals("paper")) {
                result = "You Win";
                count1++;
            }
            round++;
        }
        Round.setText("Round : " + round);
        CpuScore.setText("Opponent's Score : "+ count2);
        userScore.setText("Your Score : "+ count1);


        if(toast !=null){
            toast.cancel();
        }

        toast =Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT);
        toast.show();

        if( round > 9){
            Intent intent = new Intent(MainActivity.this, ResultActivity.class);
            intent.setFlags(FLAG_ACTIVITY_NO_HISTORY);
            if( count1 > count2 ) {
                intent.putExtra("winner", "You");
        }
            else if((count2 > count1)) {
                intent.putExtra("loser", "Computer");
            }
            else{
                intent.putExtra("draw", "No one");
            }
            startActivity(intent);
        }
    }
}
