package javacry.crypto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ciphra implements AutoCloseable {
    private static final List<Character> CONSOANTES = Arrays.asList('b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w', 'x', 'y', 'z');
    private String palavra;
    private static boolean isDestroyed = false;

    public Ciphra() {
        if (isDestroyed) {
            throw new IllegalStateException("Invalid access: The Constructor has been destroyed");
        } else {
            try {
                Scanner scan = new Scanner(System.in);

                try {
                    System.out.print("Digite a palavra que deseja cifrar: ");
                    this.palavra = scan.nextLine();
                } catch (Throwable var5) {
                    try {
                        scan.close();
                    } catch (Throwable var4) {
                        var5.addSuppressed(var4);
                    }

                    throw var5;
                }

                scan.close();
            } catch (Exception var6) {
                System.err.println("Erro ao ler entrada: " + var6.getMessage());
            }

        }
    }

    public Ciphra(String arg) {
        if (isDestroyed) {
            throw new IllegalStateException("Invalid access: The Constructor has been destroyed");
        } else if (!validarPalavra(arg)) {
            throw new IllegalArgumentException("Invalid word! Could not create object");
        } else {
            this.palavra = arg;
        }
    }

    private static boolean validarPalavra(String p) {
        if (isDestroyed) {
            throw new IllegalStateException("Invalid access: The Constructor has been destroyed");
        } else if (p.length() > 25) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } else {
            return true;
        }
    }

    public void printCiphra() {
        if (isDestroyed) {
            throw new IllegalStateException("Invalid access: The Constructor has been destroyed");
        } else {
            if (validarPalavra(this.palavra)) {
                String palavraCifrada = cifrar(this.palavra);
                System.out.println("Palavra cifrada: " + palavraCifrada);
            }

        }
    }

    private static String cifrar(String palavra) {
        if (isDestroyed) {
            throw new IllegalStateException("Invalid access: The Constructor has been destroyed");
        } else {
            StringBuilder palavraCifrada = new StringBuilder();
            char[] var2 = palavra.toCharArray();
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                char letra = var2[var4];
                if (CONSOANTES.contains(letra)) {
                    char vogalProxima = encontrarVogalMaisProxima(letra);
                    char consoanteSeguinte = encontrarConsoanteSeguinte(letra);
                    palavraCifrada.append(letra).append(vogalProxima).append(consoanteSeguinte);
                } else {
                    palavraCifrada.append(letra);
                }
            }

            return palavraCifrada.toString();
        }
    }

    private static char encontrarVogalMaisProxima(char conso) {
        char vogalMaisProxima = 'a';
        int menorDistancia = Integer.MAX_VALUE;
        char[] var3 = "aeiou".toCharArray();
        int var4 = var3.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            char vogal = var3[var5];
            int distancia = Math.abs(conso - vogal);
            if (distancia < menorDistancia || distancia == menorDistancia && vogal < vogalMaisProxima) {
                menorDistancia = distancia;
                vogalMaisProxima = vogal;
            }
        }

        return vogalMaisProxima;
    }

    private static char encontrarConsoanteSeguinte(char conso) {
        int index = CONSOANTES.indexOf(conso);
        return index < CONSOANTES.size() - 1 ? (Character)CONSOANTES.get(index + 1) : conso;
    }

    public void close() {
        System.out.print("\nDestroying constructor");

        try {
            for(int i = 1; i <= 3; ++i) {
                Thread.sleep(800L);
                System.out.print(".");
            }

            Thread.sleep(800L);
            System.out.println("\nObject(s) destroyed successfully.");
            Thread.sleep(500L);
        } catch (Exception var2) {
            Thread.currentThread().interrupt();
            System.err.println("Error while destroying: " + var2.getMessage());
        }
        isDestroyed = true;
        this.palavra = null;
    }
}

