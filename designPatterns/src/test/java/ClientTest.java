import com.tiago3monteiro.hero.Bar;
import com.tiago3monteiro.hero.HumanClient;
import com.tiago3monteiro.hero.StringBar;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ClientTest
{
    @Test
    public void addObserver() {
        Bar bar = new StringBar();
        HumanClient clientMock = Mockito.mock(HumanClient.class);
        bar.addObserver(clientMock);
        Mockito.verify(clientMock,
                Mockito.never()).happyHourStarted(bar);
        Mockito.verify(clientMock,
                Mockito.never()).happyHourEnded(bar);
        bar.startHappyHour();
        Mockito.verify(clientMock,
                Mockito.times(1)).happyHourStarted(bar);
        Mockito.verify(clientMock,
                Mockito.never()).happyHourEnded(bar);
        bar.endHappyHour();
        Mockito.verify(clientMock,
                Mockito.times(1)).happyHourStarted(bar);
        Mockito.verify(clientMock,
                Mockito.times(1)).happyHourEnded(bar);
    }
    @Test
    public void removeObserver() {
        Bar bar = new StringBar();
        HumanClient clientMock = Mockito.mock(HumanClient.class);
        bar.addObserver(clientMock);
        bar.removeObserver(clientMock);
        bar.startHappyHour();
        bar.endHappyHour();
        Mockito.verify(clientMock,
                Mockito.never()).happyHourStarted(bar);
        Mockito.verify(clientMock,
                Mockito.never()).happyHourEnded(bar);
    }
}
