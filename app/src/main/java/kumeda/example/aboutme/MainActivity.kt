package kumeda.example.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //DONEボタンがクリックされた時
        findViewById<Button>(R.id.done_button).setOnClickListener{
            addNickname(it)

        }

        //表示されているニックネームがクリックされた時
        findViewById<TextView>(R.id.nickname_text).setOnClickListener{
            updateNickname(it)
        }
    }

    private fun addNickname(view: View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)

        //入力したニックネームを表示するニックネームへいれる
        nicknameTextView.text = editText.text
        //ニックネーム入力蘭を消す
        editText.visibility = View.GONE
        //DONEボタンを消す
        view.visibility = View.GONE
        //ニックネームを表示する
        nicknameTextView.visibility = View.VISIBLE

        // キーボードを隠す
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickname(view: View){
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val doneButton = findViewById<Button>(R.id.done_button)

        //ニックネーム入力蘭を表示
        editText.visibility = View.VISIBLE
        //DONEボタンを表示
        doneButton.visibility = View.VISIBLE
        //表示されていたニックネームを消す
        view.visibility = View.GONE

        // ニックネーム入力蘭にフォーカスを変える
        editText.requestFocus()

        // キーボードを表示する
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(editText, 0)
    }
}