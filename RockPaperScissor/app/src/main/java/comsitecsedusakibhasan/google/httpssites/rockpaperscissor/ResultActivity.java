package comsitecsedusakibhasan.google.httpssites.rockpaperscissor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView textView = (TextView) findViewById(R.id.winner);
        TextView textView1 = (TextView) findViewById(R.id.loser);
        TextView textView2 = (TextView) findViewById(R.id.draw);

        if (getIntent().hasExtra("winner")) {
            String  w = getIntent().getStringExtra("winner");
            String win = "Congratulations!!!\n\n"+ w+" are the final winner. \n" ;
            textView.setText(win);
        }
        else if (getIntent().hasExtra("loser")) {
            String  w = getIntent().getStringExtra("loser");
            String lose = "You Lost!!!\nThe final winner is : \n" + w + "\nBetter Luck Next Time\n";
            textView1.setText(lose);
        }
        else textView2.setText("No one won, its a draw :( \n\nBetter Luck Next Time!");
    }
}

