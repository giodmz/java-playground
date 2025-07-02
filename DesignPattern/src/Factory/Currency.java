package Factory;

/*
* O Factory Method é um padrão criacional de projeto que fornece uma interface
* para criar objetos em uma superclasse, mas permite que as subclasses
* alterem o tipo de objetos que serão criados.
* É utilizado para desacoplar a lógica de criação da classe do resto do código
* para facilitar a manutenção */

public interface Currency {
    String getSymbol();
}

class Real implements Currency {
    @Override
    public String getSymbol() {
        return "";
    }
}

class UsDollar implements Currency {

    @Override
    public String getSymbol() {
        return "";
    }
}
