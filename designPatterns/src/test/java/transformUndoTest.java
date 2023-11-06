import com.tiago3monteiro.hero.StringCaseChanger;
import com.tiago3monteiro.hero.StringDrink;
import com.tiago3monteiro.hero.StringInverter;
import com.tiago3monteiro.hero.StringReplacer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class transformUndoTest {

    @Test
    public void transformUndo() {
        StringDrink drink = new StringDrink( "AbCd-aBcD");
        StringInverter si = new StringInverter();
        StringCaseChanger cc = new StringCaseChanger();
        StringReplacer sr = new StringReplacer('A', 'X');
        si.execute(drink);
        cc.execute(drink);
        sr.execute(drink);
        sr.undo(drink);
        assertEquals("dCbA-DcBa", drink.getText());
        cc.undo(drink);
        assertEquals("DcBa-dCbA", drink.getText());
        si.undo(drink);
        assertEquals("AbCd-aBcD", drink.getText());
    }



}