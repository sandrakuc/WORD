package word.system.exam.examResultComposite;

import org.junit.Assert;
import org.junit.Test;


import static org.junit.Assert.*;

public class WholeAbstractExamResultCompositeTest {
    @Test
    public void getResultInPercent() throws Exception {

        // ========= arange:
        /*WholeExamResultComposite wholeExamResultComposite = new WholeExamResultComposite();

        PkkExamResultComposite andrzej = new PkkExamResultComposite();
        PkkExamResultComposite janusz = new PkkExamResultComposite();
        wholeExamResultComposite.add(andrzej);
        wholeExamResultComposite.add(janusz);


        QuestionComposite pytanie1andrzej = new QuestionComposite();
        QuestionComposite pytanie2andrzej = new QuestionComposite();
        QuestionComposite pytanie1janusz = new QuestionComposite();
        QuestionComposite pytanie2janusz = new QuestionComposite();
        andrzej.add(pytanie1andrzej);
        andrzej.add(pytanie2andrzej);
        janusz.add(pytanie1janusz);
        janusz.add(pytanie2janusz);

        //andrzej == dobrze 100%
        pytanie1andrzej.add(new AnswerLeaf(new Answer("jakaśodp",true)));
        pytanie1andrzej.add(new AnswerLeaf(new Answer("jakaśodp",true)));

        //andrzej == zle 0%
        pytanie2andrzej.add(new AnswerLeaf(new Answer("jakaśodp",false)));
        pytanie2andrzej.add(new AnswerLeaf(new Answer("jakaśodp",false)));

        //janusz == całkiem źle 0%
        pytanie1janusz.add(new AnswerLeaf(new Answer("jakaśodp",false)));
        pytanie1janusz.add(new AnswerLeaf(new Answer("jakaśodp",false)));

        //janusz ==  zaznaczył jedną odpowiedz poprawnie, drugą niepoprawnie 50%
        pytanie2janusz.add(new AnswerLeaf(new Answer("jakaśodp",false)));
        pytanie2janusz.add(new AnswerLeaf(new Answer("jakaśodp",true)));

        // ======== asserts:

        //pytania
        Assert.assertEquals(1, pytanie1andrzej.getResultInPercent(), 0.01);
        Assert.assertEquals(0, pytanie2andrzej.getResultInPercent(), 0.01);

        Assert.assertEquals(0, pytanie1janusz.getResultInPercent(), 0.01);
        Assert.assertEquals(0.5, pytanie2janusz.getResultInPercent(), 0.01);

        //zdający
        Assert.assertEquals(0.5, andrzej.getResultInPercent(), 0.01);
        Assert.assertEquals(0.25, janusz.getResultInPercent(), 0.01);

        // cały egzamin
        Assert.assertEquals(0.375, wholeExamResultComposite.getResultInPercent(), 0.01 );*/
    }

}