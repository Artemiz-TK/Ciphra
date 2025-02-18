# Ciphra "Simples"

#### Fiz esse projeto para me desafiar a conseguir ter ainda mais dominio sobre essa otima linguagem de alto nível

### Minha versão do JDK é o 23, disponível [Aqui](https://www.oracle.com/br/java/technologies/downloads/#java23)

## Passo-a-passo
#### Antes de tudo, se não estiver usando, baixe o [git](https://git-scm.com/downloads). Se já tiver, então clone o repositório:
```bash
git clone https://github.com/LucasAlanderson/Ciphra.git
```
#### Sugiro que clone o repositório em algum diretório que já tenha códigos, para que não bagunce seus diretórios

#### Depois disso, mova o diretório `javacry`, voltanddo um diretório e depois remova o repositório `Ciphra`:
```bash
mv Ciphra/javacry ../
rmdir Ciphra
```
### Após isso, crie algum arquivo Java com o metodo main. Para facilitar sua vida, eu vou deixar um arquivo já pronto.

</br>

![Static Badge](https://img.shields.io/badge/⚠️Atenção⚠️-ffea00?style=for-the-badge&logoSize=30)
### Coloque o nome do arquivo que você criar no nome da classe. No meu caso, o nome do arquivo seria ``Main.java``

```java
import javacry.crypto.Ciphra;

public class Main {
    public static void main(String[] args) {
        Ciphra ciphra = new Ciphra();
        ciphra.printCiphra();
        ciphra.close();
    }
}

```

### Agora é só executar por interface de alguma IDE ou fazer via terminal.
```bash
javac Main.java # coloque o nome do arquivo java que você criou
java Main # mesmo processo de cima, só que aqui não tem extensão
```

#### E pronto! você já deve tá vendo alguma saída no seu terminal. Espero que consiga usar isso pra estudar e melhorar suas habilidades com o Java :)

---

### PS: Pretendo depois fazer uma automação com sh para que vá para o bin do Java, mas não sei se é tão util... Enfim, termino esse README por aqui. Obrigada a quem quer que esteja vendo isso. Fique com essa citação: 

> Nem sempre é amigo aquele que te tira do buraco </br>Artista: `Saddam Hussein`
