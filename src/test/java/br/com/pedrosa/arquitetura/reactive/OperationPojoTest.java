package br.com.pedrosa.arquitetura.reactive;


import br.com.pedrosa.arquitetura.reactive.domain.Operation;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

public class OperationPojoTest {

    @Test
    public void create(){
        Operation op = new Operation("1","teste");
        Assert.assertEquals(op.getName(),"teste");
        Assert.assertThat(op.getName(), Matchers.equalToIgnoringCase("TESTE"));
        Assertions.assertThat(op.getName()).isEqualToIgnoringCase("teste");
    }
}
