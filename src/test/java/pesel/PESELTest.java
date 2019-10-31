package pesel;

public class PESELTest {
    package pesel;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

    @RunWith(Arquillian.class)
    public class PESELTest {
        @Deployment
        public static JavaArchive createDeployment() {
            return ShrinkWrap.create(JavaArchive.class)
                    .addClass(PESEL.class)
                    .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        }



        private PESEL peselOne = new PESEL(99051208635L);
        private PESEL peselTwo = new PESEL(99051208630L);

        @Test
        public void getPESEL() {
            long peselGetTest = peselOne.getLen();
        }

        @Test
        public void getDigits() {
            int[] peselSplitTest = peselOne.getDigits();
        }

        @Test
        public void getLen() {
            int peselGetLenTest = peselOne.getLen();
        }

        @Test
        public void isValid() {
            assertTrue("Ten pesel jest dobry", peselOne.isValid(peselOne.getDigits()));
            assertFalse("Ten pesel jest niepoprawny", peselTwo.isValid(peselTwo.getDigits()));
        }
    }
}
