package com.example.myowncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView history; // создаю переменную для записи предыдущего числа
    EditText editText; // Создаю переменную editText класса EditText
    String oldNumber; // Создаю переменную для записи первого числа для оперции (+, - , / , *)
    String operator = ""; // Создаю переменную для знака оперции : * или + или - или /
    Boolean isNew = true; // Создаю переменную для того, чтобы обновлять вводную строку

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//       Выше написанное заменил все через 1 переменную editText для кнопок цифр. Присваиваю переменной id поля ввода чисел.
        editText = findViewById(R.id.edit_number_field);
        history = findViewById(R.id.field_o_history);

    }

    public void clickNumber(View view) {
        if (isNew) {
            editText.setText("");
        }
        isNew = false;

        String number = editText.getText().toString(); // присваиваю переменной number значение из edit_number_field и стрингую ее.
        // ниже написан оператор, который выполняет следующее : когда наживаю на кнопку 7, id этой кнопки попадает в оператор, далее,
        // он сравнивается с одним из значений в case  и выполняет условие, прописанное в данном case. В нашем случае к написанной цифре
        // дописываем цифру, кнопку которой нажали, после остановить дейсвтие оператора. Дописали все бля всех кнопок цифр
        // и для кнопки точки, плюса и минуса

        switch (view.getId()) {
            case R.id.button1:
                if (zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number + "1";
                break;
            case R.id.button2:
                if (zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number + "2";
                break;
            case R.id.button3:
                if (zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number + "3";
                break;
            case R.id.button4:
                if (zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number + "4";
                break;
            case R.id.button5:
                if (zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number + "5";
                break;
            case R.id.button6:
                if (zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number + "6";
                break;
            case R.id.button7:
                if (zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number + "7";
                break;
            case R.id.button8:
                if (zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number + "8";
                break;
            case R.id.button9:
                if (zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                }
                number = number + "9";
                break;
            case R.id.button0:

                if (zeroIsFirst(number) && number.length() == 1) { // проверка на ноль первым числом
                    number = "0";
                } else {
                    number = number + "0";
                }
                break;


            case R.id.button_float:
                if (dotIsPresent(number)) { // проверка наличия точки
                } else {
                    number = number + ".";
                }
                break;


            case R.id.button_sign_change:

                if (numberIsZero(number)) {  // проверка нуля для кнопки +-

                    number = "0";
                } else {

                    if (minus_is_present(number)) { // проверка наличия минуса
                        number = number.substring(1);
                    } else {
                        number = "-" + number;
                    }
                    break;
                }
        }
        editText.setText(number); // устанавливаем значение number, которое набираем в наше поле ввода чисел (edit_number_field)
    }

    // создаем метод для знаков оперции ( + , - , * , /)

    public void operation(View view) {

        isNew = true;// для того, чтобы когда вводилось второе число, оно не писалось рядом с первым, а заменяла его
        oldNumber = editText.getText().toString(); // К переменной oldNumber присваюваю значение из editText (то, которые мы ввели ранее)

        switch (view.getId()) {
            case R.id.button_minus:
                operator = "-";
                break;
            case R.id.button_plus:
                operator = "+";
                break;
            case R.id.button_division:
                operator = "/";
                break;
            case R.id.button_multiply:
                operator = "*";
                break;
        }

        history.setText((oldNumber = editText.getText().toString()) + " " + operator); // вывожу в после истории первое число  и операцю

    }

    // создаем метод для кнопки равно (т.е. нахождение результата оперции)
    public void find_result(View view) {

        String newNumber = editText.getText().toString();
        Double result = 0.0;

        if ((Double.parseDouble(newNumber)<0.00000001 && operator == "/" ) || (newNumber.equals("") &&  operator == "/")){
            Toast.makeText(this,  R.string.toast_massage, Toast.LENGTH_SHORT).show();
        }
        else {

            switch (operator) { // в данному случае смотрим не id, а значение введенного оператора
                case "-":
                    result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                    break; // Double.parseDouble() позволяет перевести введеные значение в формат чисел с плавающей точков и считать их
                case "+":
                    result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                    break; // Double.parseDouble() позволяет перевести введеные значение в формат чисел с плавающей точков и считать их
                case "/":

                    result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                    break; // Double.parseDouble() позволяет перевести введеные значение в формат чисел с плавающей точков и считать их
                case "*":
                    result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                    break;// Double.parseDouble() позволяет перевести введеные значение в формат чисел с плавающей точков и считать их
            }
            editText.setText(result + "");  // добавили кавычки к выводу информации т.к. требуется строка
            history.setText(oldNumber + " " + operator + " " + newNumber + " =");
        }
    }

    // Создание метода для кнопки С для отчистки вводного поля
    public void Clear(View view) {
        isNew = true;
        editText.setText("0");
        history.setText("");
    }

    //метод проверки наличия точки. Читается так: если в числе не было точки, то возвращаем ложь иначе вернет правда
    public boolean dotIsPresent(String number) {
        if (number.indexOf(".") == -1) {
            return false;
        } else {
            return true;
        }
    }

    //метод проверки наличия минуса
    public boolean minus_is_present(String number) {
        if (number.charAt(0) == '-') {
            return true;
        } else {
            return false;
        }
    }

    // метод кнопки процента (%)
    public void clickPercent(View view) {

        if (operator == "") {
            String number = editText.getText().toString();
            double temt = Double.parseDouble(number) / 100;
            number = temt + "";
            editText.setText(number);
        } else {
            String newNumber = editText.getText().toString();
            Double result = 0.0;
            switch (operator) { // в данному случае смотрим не id, а значение введенного оператора
                case "-":
                    result = Double.parseDouble(oldNumber) - Double.parseDouble(oldNumber) * Double.parseDouble(newNumber) / 100;
                    break;
                case "+":
                    result = Double.parseDouble(oldNumber) + Double.parseDouble(oldNumber) * Double.parseDouble(newNumber) / 100;
                    break;
                case "/":
                    result = Double.parseDouble(oldNumber) / Double.parseDouble(oldNumber) * Double.parseDouble(newNumber) / 100;
                    break;
                case "*":
                    result = Double.parseDouble(oldNumber) * Double.parseDouble(oldNumber) * Double.parseDouble(newNumber) / 100;
                    break;
            }
            editText.setText(result + "");
            operator = "";
        }
    }

    //метод проверки числа на 0 для фкнопки +-
    public boolean numberIsZero(String number) {
        if (number.equals("0") || number.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    //метод проверки нуля первым числом (исключение возможности ввести 00000000)
    public boolean zeroIsFirst(String number) {
        if (number.equals("")) {
            return true;
        }
        if (number.charAt(0) == '0') {
            return true;
        } else {
            return false;
        }
    }


}


