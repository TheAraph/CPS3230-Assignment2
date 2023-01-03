package logintests;

import logintests.enums.LoginStateEnum;
import nz.ac.waikato.modeljunit.Action;
import nz.ac.waikato.modeljunit.FsmModel;
import nz.ac.waikato.modeljunit.GreedyTester;
import nz.ac.waikato.modeljunit.StopOnFailureListener;
import nz.ac.waikato.modeljunit.coverage.ActionCoverage;
import nz.ac.waikato.modeljunit.coverage.StateCoverage;
import nz.ac.waikato.modeljunit.coverage.TransitionPairCoverage;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.logintests.Main;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class LoginModelTest implements FsmModel {
    Main sut = new Main();

    static WebDriver driver;

    LoginStateEnum stateEnum = LoginStateEnum.Logout;
    boolean LoginPage = false;
    boolean AlertsPage = false;
    boolean LogOut = false;

    boolean ValidLogin = false;

    //teardown method so as to not get confused with sessions


    @Override
    public LoginStateEnum getState() {
        return stateEnum;
    }

    @Override
    public void reset(boolean b) {

        if (b){
            sut = new Main();
        }

        LoginPage = false;
        AlertsPage = false;
        LogOut = false;
        ValidLogin = false;
        stateEnum = LoginStateEnum.Logout;
    }

    public boolean LogInGuard() {
        return getState().equals(LoginStateEnum.Logout);
    }
    public @Action void LogIn() throws InterruptedException {
        sut.validLoginTest();

        stateEnum = LoginStateEnum.Login;
        AlertsPage = true;
        ValidLogin = true;

        Assert.assertEquals(AlertsPage && ValidLogin, sut.isAlertPage());
        Assert.assertEquals(ValidLogin, sut.isValidLogin());
        driver.quit();
    }

    public boolean LogOutGuard(){
        return getState().equals(LoginStateEnum.Login);
    }
    public @Action void LogOut() throws InterruptedException {
        sut.manualLogOutTest();

        stateEnum = LoginStateEnum.Logout;
        AlertsPage = false;
        ValidLogin = false;
        LoginPage = true;
        LogOut = true;

        Assert.assertEquals(LogOut && LoginPage, sut.isLoginPage());
        Assert.assertEquals(LogOut, sut.isLoggedOut());
        driver.quit();
    }

    public boolean invalidLogInGuard(){
        return getState().equals(LoginStateEnum.Logout);
    }
    public @Action void invalidLogIn() throws InterruptedException {
        sut.invalidLoginTest();

        stateEnum = LoginStateEnum.Logout;
        AlertsPage = false;
        ValidLogin = false;
        LoginPage = true;
        LogOut = true;

        Assert.assertEquals(LogOut && LoginPage, sut.isLoginPage());
        Assert.assertEquals(LogOut, sut.isLoggedOut());
        driver.quit();
    }

    @Test
    public void Runner() {
        final GreedyTester tester = new GreedyTester(new LoginModelTest()); //Creates a test generator that can generate random walks. A greedy random walk gives preference to transitions that have never been taken before. Once all transitions out of a state have been taken, it behaves the same as a random walk.
        tester.setRandom(new Random()); //Allows for a random path each time the model is run.
        tester.buildGraph(); //Builds a model of our FSM to ensure that the coverage metrics are correct.
        tester.addListener(new StopOnFailureListener()); //This listener forces the test class to stop running as soon as a failure is encountered in the model.
        tester.addListener("verbose"); //This gives you printed statements of the transitions being performed along with the source and destination states.
        tester.addCoverageMetric(new TransitionPairCoverage()); //Records the transition pair coverage i.e. the number of paired transitions traversed during the execution of the test.
        tester.addCoverageMetric(new StateCoverage()); //Records the state coverage i.e. the number of states which have been visited during the execution of the test.
        tester.addCoverageMetric(new ActionCoverage()); //Records the number of @Action methods which have ben executed during the execution of the test.
        tester.generate(500); //Generates 500 transitions
        tester.printCoverage(); //Prints the coverage metrics specified above.
    }
}
