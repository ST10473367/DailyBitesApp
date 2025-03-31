package za.ac.iie.dailybitesapp


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import za.ac.iie.dailybitesapp.ui.theme.DailyBitesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Declaring my variables
        val Greetings = findViewById<TextView>(R.id.Greetings)
        val inputTimeOfDay = findViewById<EditText>(R.id.inputTimeOfDay)
        val suggestButton = findViewById<Button>(R.id.suggestButton)
        val resultText = findViewById<TextView>(R.id.resultText)
        val resetButton = findViewById<Button>(R.id.resetButton)

        // Setting up the button click listener
        suggestButton.setOnClickListener {
            val TimeOfDay = inputTimeOfDay.text.toString().trim().lowercase()

            // Suggest food based on time of day after user clicks on suggest button
            val FoodSuggestion = when (TimeOfDay) {
                "morning" -> "Breakfast: 1.Avocado Toast, 2.Coco Pops , 3.Pancakes , 4.Cheese toast, 5.Granola with yogurt"
                "mid morning" -> "Mid Morning Snack: 1.Fresh Fruit Salad, 2.Ramen Noodles , 3.Eggs and Bacon, 4.Scones, 5.Lentil Soup"
                "afternoon" -> "Lunch: 1.Burger, 2.Pizza, 3.Chicken curry, 4.Chicken wings, 5.Chicken tikka"
                "mid afternoon" -> "Mid Afternoon Snacks: 1.Cheese and Crackers, 2.Grilled Chicken Sandwich, 3.Samosas, 4.Tacos, 5.Meatballs with marinara sauce"
                "evening" -> "Dinner: 1.Roast Chicken and Chips, 2.Spaghetti Bolognese, 3.Pork Chops, 4.Vegetable Stir-Fry, 5.Butter Chicken"
                else -> null
            }

            // If FoodSuggestion is not null, show it, otherwise show error
            if (FoodSuggestion != null) {
                resultText.text = "Suggested Food: $FoodSuggestion"
            } else {
                Toast.makeText(this, "Invalid input, Please enter a valid time of the day.", Toast.LENGTH_SHORT).show()
                resultText.text = ""
            }
        }

        // Reset button to clear the input and result
        resetButton.setOnClickListener {
            inputTimeOfDay.text.clear()
            resultText.text = ""
        }
    }
}
