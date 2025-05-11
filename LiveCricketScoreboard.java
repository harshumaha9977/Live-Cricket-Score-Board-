import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class LiveCricketScoreboard extends Frame {

    Label matchTitle, teamA, teamB, scoreLabel, wicketLabel, overLabel, statusLabel;
    Button refreshBtn;

    // Simulated data (replace with actual API call)
    String currentScore = "IND 120/3";
    String overs = "14.2";
    String status = "India needs 80 runs in 34 balls";
    String team1 = "India";
    String team2 = "Australia";

    public LiveCricketScoreboard() {
        setTitle("Live Cricket Scoreboard");
        setSize(500, 400);
        setLayout(null);
        setBackground(new Color(245, 245, 245));

        matchTitle = new Label("Live Match: India vs Australia", Label.CENTER);
        matchTitle.setBounds(50, 50, 400, 40);
        matchTitle.setFont(new Font("Arial", Font.BOLD, 18));
        add(matchTitle);

        teamA = new Label("Team A: " + team1);
        teamA.setBounds(50, 100, 200, 30);
        teamA.setFont(new Font("Arial", Font.PLAIN, 14));
        add(teamA);

        teamB = new Label("Team B: " + team2);
        teamB.setBounds(270, 100, 200, 30);
        teamB.setFont(new Font("Arial", Font.PLAIN, 14));
        add(teamB);

        scoreLabel = new Label("Score: " + currentScore);
        scoreLabel.setBounds(50, 150, 300, 30);
        scoreLabel.setFont(new Font("Arial", Font.BOLD, 16));
        add(scoreLabel);

        wicketLabel = new Label("Wickets: 3");
        wicketLabel.setBounds(50, 190, 200, 30);
        wicketLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        add(wicketLabel);

        overLabel = new Label("Overs: " + overs);
        overLabel.setBounds(270, 190, 200, 30);
        overLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        add(overLabel);

        statusLabel = new Label("Status: " + status);
        statusLabel.setBounds(50, 230, 400, 30);
        statusLabel.setFont(new Font("Arial", Font.ITALIC, 14));
        add(statusLabel);

        refreshBtn = new Button("Refresh Score");
        refreshBtn.setBounds(180, 280, 130, 40);
        refreshBtn.setFont(new Font("Arial", Font.BOLD, 14));
        add(refreshBtn);

        refreshBtn.addActionListener(e -> fetchScore());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });

        setVisible(true);

        // Auto update every 10 seconds
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                fetchScore();
            }
        }, 0, 10000);
    }

    // Simulate fetching from API (replace this method to use actual API logic)
    private void fetchScore() {
        // Here you'd do HTTP GET request to API and parse the JSON
        // For demo: simulate random update
        int randScore = 120 + (int)(Math.random() * 30);
        int randWickets = 3 + (int)(Math.random() * 3);
        double randOvers = 14 + Math.random() * 4;

        currentScore = team1 + " " + randScore + "/" + randWickets;
        overs = String.format("%.1f", randOvers);
        status = "India needs " + (200 - randScore) + " runs";

        scoreLabel.setText("Score: " + currentScore);
        wicketLabel.setText("Wickets: " + randWickets);
        overLabel.setText("Overs: " + overs);
        statusLabel.setText("Status: " + status);
    }

    public static void main(String[] args) {
        new LiveCricketScoreboard();
    }
}
