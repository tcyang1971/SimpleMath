package tw.edu.pu.csim.tcyang.simplemath

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var x:Int = 0
    var y:Int = 0
    var Answer: Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        GenerateQuestion()

        btnReGen.setOnClickListener(object: View.OnClickListener{
            override fun onClick(p0: View?) {
                GenerateQuestion()
            }
        })

        btnSend.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                if (edtResult.text.toString() == "") {
                    Toast.makeText(baseContext, "請輸入您的答案再送出", Toast.LENGTH_SHORT).show()
                } else {
                    intent = Intent(this@MainActivity, AnswerActivity::class.java).apply {
                        putExtra("You", edtResult.text.toString())
                        putExtra("Correct", Answer.toString())
                    }
                    startActivity(intent)
                }
            }
        })

    }

    fun GenerateQuestion(){
        x = (0..100).random()
        y = (0..100).random()
        Answer = x.toFloat() + y.toFloat()
        txvQuestion.text = x.toString() + " + " + y.toString() + " = "
        edtResult.text = null
    }
}