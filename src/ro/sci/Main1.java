package ro.sci;

import java.util.Scanner;

public class Main1 {

    public static void main(String[] args){

        Book carte1 = new Book();
        carte1.setNume("carte1");
        carte1.setNrPagini(10);

        Book carte2 = new Book();
        carte2.setNume("carte2");
        carte2.setNrPagini(100);

        Novel nuv1 = new Novel();
        nuv1.setNume("nuv1");
        nuv1.setNrPagini(100);
        nuv1.setType("nuvela");

        Novel nuv2 = new Novel();
        nuv2.setNume("nuv2");
        nuv2.setNrPagini(500);
        nuv2.setType("nuvela");

        ArtAlbum art1 = new ArtAlbum();
        art1.setNume("art1");
        art1.setNrPagini(20);
        art1.setCaliateHartie("cool");

        ArtAlbum art2 = new ArtAlbum();
        art2.setNume("art2");
        art2.setNrPagini(40);
        art2.setCaliateHartie("awsome");

        Book nuvela = new Novel();
        nuvela.setNume("nuv1");
        nuvela.setNrPagini(100);
        ((Novel) nuvela).setType("action");


        Book albumArta = new ArtAlbum();
        albumArta.setNume("art2");
        albumArta.setNrPagini(40);
        ((ArtAlbum) albumArta).setCaliateHartie("impressive");



        Library librarie = new Library();

        librarie.addBook(carte1);
        librarie.addBook(carte2);
        librarie.addBook(nuv1);
        librarie.addBook(nuv2);
        librarie.addBook(nuvela);
        librarie.addBook(albumArta);


        //TODO homework
        // 1. stergeti o carte
        // 2. metoda voastra specifica 1
        // 3. metoda voastra specifica 2

        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter an integer");
        int myint = keyboard.nextInt();
        String myString = keyboard.nextLine();

        System.out.println("Am citit:" + myint);
        System.out.println("Am citit:" + myString);


    }
}
