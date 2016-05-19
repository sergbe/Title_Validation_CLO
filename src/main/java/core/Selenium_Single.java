package core;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;


@Parameters(separators="|")

public class Selenium_Single {

    //CLO
    public static final String URL="--url";
    public static final String sURL="-u";

    public static final String Title_Expected="--title";
    public static final String sTitle="-t";

    public static final String Test_case_id="--tcase";
    public static final String sTest_case_id="-c";

    public static final String Help="--help";
    public static final String sHelp="-h";

    // @Parameter(names={URL, sURL}, description ="URL of Web site", required = true)
    @Parameter(names={URL, sURL}, description ="URL of Web site")
    private static String url="http://www.learn2test.net";

    @Parameter(names={Title_Expected, sTitle}, description ="Expected title")
    // required=true
    private static String title_expected="learn2test.net";

    @Parameter(names={sTest_case_id, Test_case_id}, description ="Test case ID - > TC-xxx.xx")
    private static String text_case_id="TC-001.01";

    @Parameter(names ={Help, sHelp}, help = true, hidden = true)
    private static boolean help;


    public static void main(String[] args) {
        new JCommander(new Selenium_Single(), args);
//      JCommander cli = new JCommander(new Selenium_Single(), args);
        if (help) {
            new JCommander(new Selenium_Single(), args).usage();
//     	                    cli.usage();
            System.exit(0);
        }


        WebDriver driver = new FirefoxDriver();


        driver.get(url);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        String title_actual = driver.getTitle();

        if (title_expected.equals(title_actual)) {
            System.out.println();
            System.out.println(">>>..........");
            System.out.println("Test Case ID: \t\t" + text_case_id);
            System.out.println("URL: \t\t\t" + url);
            System.out.println("Title Expected: \t" + title_expected);
            System.out.println("Title Actual: \t\t" + title_actual);
            System.out.println("Test Case Result: \t" + "PASSED");
            System.out.println("..........<<<");
            System.out.println();

        } else {
            System.out.println(">>>..........");
            System.out.println("Test Case ID: \t\t" + text_case_id);
            System.out.println("URL: \t\t\t" + url);
            System.out.println("Title Expected: \t" + title_expected);
            System.out.println("Title Actual: \t\t" + title_actual);
            System.out.println("Test Case Result: \t" + "FAILED");
            System.out.println("..........<<<");
            System.out.println();
        }
        driver.quit();
    }
}