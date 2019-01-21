

        package ru.stqa.selenium.util;

        import org.testng.annotations.DataProvider;

        import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.Iterator;
        import java.util.List;
        import java.util.Random;

public class DataProviders {

//*********************формирует лист если несколько раз используется**************//

    @DataProvider
    public static Iterator<Object[]> CreateAccountProvider() throws IOException {
        return chooseDataFromFile("/CreateAccount.data");
    }

    @DataProvider
    public static Iterator<Object[]> loginNegativeProvider() throws IOException {
        return chooseDataFromFile("/LoginNegative.data");
    }
    @DataProvider
    public static Iterator<Object[]> loginPositiveProvider() throws IOException {
        return chooseDataFromFile("/loginPositive.data");
    }




        public static Iterator<Object[]> chooseDataFromFile(String fileName) throws IOException {
            BufferedReader in = new BufferedReader(new InputStreamReader(DataProviders.class.getResourceAsStream(fileName)));
            List<Object[]> userData = new ArrayList<>();

            for(String line = in.readLine(); line != null; line = in.readLine()) {
                userData.add(line.split(";"));
            }

            in.close();
            return userData.iterator();
        }
//************************************************************************//

    @DataProvider
    public static Iterator<Object[]> LoginList() {//вставляем значения сюда/создается лист для использования
        List<Object[]> data = new ArrayList ();
        data.add ( new Object[]{"yanina56@gmail.com", "123456"} );
        data.add ( new Object[]{"yanayanayanayana777@gmail.com", "abcdifg"} );
        data.add ( new Object[]{"y777@gmail.com", "000000"} );

        return data.iterator ();
    }

    @DataProvider
    public Iterator<Object[]> randomUsers() {//рандомный метод
        List<Object[]> data = new ArrayList(); //создаем лист итерируем массив обьектов

        for(int i = 0; i < 2; ++i) {
            data.add(new Object[]{this.generateRandomName(7), this.generateRandomPassword()});
            //метод генерации рандомного имени и пароля
        }

        return data.iterator();
    }
    //*********************методы используются в randomUsers() @DataProvider****************************//
    private Object generateRandomPassword() {
        return "2345"+ (new Random ()).nextInt();
    }

   //private Object generateRandomName() {
       // return  "Yana"+(new Random()).nextInt()+"@gmail.com";
   // }
    private Object generateRandomName(int length){ //metod mail
        String str = "";
        int number;
        Random gen = new Random ();
        do {
            number = '0' + gen.nextInt('z' - '0' +1);
            if ((number <= '9') || (number >= 'A' && number <= 'Z') || (number >= 'a'))
            {
                str = str + (char)number;
            }
        }while(str.length()<length);
        return str+"@gmail.com";
    }

}
