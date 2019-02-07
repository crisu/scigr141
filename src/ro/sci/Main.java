package ro.sci;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {

    //punct de lansare ->entry point
    public static void main(String[] args) {

        //instantiere Book
        Book b = new Book();
        //folosirea seterilor pt popularea camputilor/atributelor obiectului b de tip Book
        b.setNrPagini(12);
        b.setNume("ceva carte");
        //aceesarea directa a campurilor nu este posibila datorita muatorului private
        //b.nume = "ceva carte"; ->devine posibil daca modificam muatorului campului nume in clasa Book la public

        //instantiere ArtAlbum
        ArtAlbum art = new ArtAlbum();
        //folosirea seterului pt popularea camputilor/atributelor obiectului art de tip ArtAlbum
        art.setCaliateHartie("awsome");

        //instantiere Novel
        Novel nov = new Novel();
        //folosirea seterului pt popularea camputilor/atributelor obiectului nov de tip Novel
        nov.setType("action");

        //afisam la consola rezultatul metodei toString din obiectul art de tip ArtAlbum
        System.out.println(art.toString());

        //afisam la consola rezultatul metodei toString din obiectul nov de tip Novel
        //-> mentionam ca obiectul mosteneste metoda de la super clasa lui de tip Book,
        //deoarece el nu are definita acea metoda
        System.out.println("NUVELA " + nov.toString());

        //instantiem o lista o lista care va contine obiecte com patibile cu tipul Book
        // https://www.youtube.com/watch?v=d3QbptJRln4
        // https://www.geeksforgeeks.org/list-interface-java-examples/
        // https://docs.oracle.com/javase/8/docs/api/java/util/List.html
        List<Book> listaCarti = new ArrayList<>();

        //adaugam listei obiectul b de tip Book
        listaCarti.add(b);
        //adaugam listei obiectul art de tip ArtArtAlbum(sub tip al tipului Book)
        listaCarti.add(art);
        //adaugam listei obiectul nov de tip Novel(sub clasa a clasei Book )
        listaCarti.add(nov);
        // mai sus am folosit slang atat la nivel de obiect ->tip<-
        // cat si la nivel de clasa ->sub clasa<-

        //adaugam listei un obiect instantiat local (sau obiect anonim, deoarece nu are o variabila atasata)
        listaCarti.add(new Novel("drama"));

        //eliminarea obiectului b din lista este posibila dat fiind ca avem referinta catre obiectul respectiv
        //am comentat pt ca nu doresc asta in momentul acesta
        //listaCarti.remove(b);

        //incercarea de eliminare a unui astfel de obiect nu este posibila
        //deoarece doua cuiere ce au aceeasi culoare nu sunt acelasi cuier
        //listaCarti.remove(new Novel("drama"));


        //INCERCARE DE STERGERE A UNUI ELEMENT DIN LISTA
        //folosind un for cu generice -> eu zic ca nu va intereseaza termenul inca
        //IMPORTANT - la fiecare iterare variabila book de tip Book ia valoarea unui element prezent in lista
        //la fiecare pas se verifica daca obiectul curent este de tip Novel
        //daca obiectul curent a avut tipul Novel se face cast la tipul Novel
        //daca obiectul curent, al carui tip este acum Novel, are campul type egal cu stringul "drama"
        //atunci vom incerca stergera lui

        //acest cod nu va functiona deoarece incercam sa modificam colectia in timp ce aceasta este parcursa
        //eroare primita va fi de tip java.util.ConcurrentModificationException
//        for(Book carte: listaCarti){
//            if(carte instanceof Novel){
//                if(((Novel) carte).getType().equals("drama"))
//                    listaCarti.remove(carte);
//            }
//        }


        //modalitatea corecta de a sterge un element dintr-o lista este cea folosind un iterator
        //https://www.youtube.com/watch?v=5TaZbcXkpxs
        //https://www.baeldung.com/java-iterator
        //https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

        //afisam dimensiunea curenta a listei inainte de stergere
        System.out.println("size lista : " + listaCarti.size());

        Iterator<Book> it1 = listaCarti.iterator();

        while (it1.hasNext()) {
            Book book = it1.next();
            if (book instanceof Novel) {
                if (((Novel) book).getType().equals("drama")) {
                    // aici am facut o gresala la curs, stergem din iterator nu din colectie :| elementul curent
                    it1.remove();
                }
            }
        }
        //afisam dimensiunea curenta a listei dupa stergere care este mai mica acum cu 1
        System.out.println("size lista : " + listaCarti.size());

        //un alt exemplu gresit -.intentionat
        // instantiem o colectie de Novel
        // colectia accepta obiectul  nov de tip Novel
        // colectia nu accepta obiectul b de tip Book(super tip al lui Novel) doar daca facem cast explicit
        // colectia nu accepta deloc obiectul art de tip ArtAlbum deoarece nu are nici o relatie cu Novel
//        List<Novel> listaCarti1 = new ArrayList<>();
//        listaCarti1.add((Novel)b);
//        listaCarti1.add((Novel)art);
//        listaCarti1.add(nov);


        //modalitate de parcurgere a listei folosind indexi
        // afisarea elementelor pe baza indexuluiu incrementat de for in fiecare pas
        for (int index = 0; index < listaCarti.size(); index++) {
            System.out.println("for 1: " + listaCarti.get(index).toString());
        }

        //modalitate de parcurgere a listei folosind generice(again tot ce trebuie sa rertineti e ca la fiecare pas
        // variabila book ia pe rand fiecare element al listei)
        // afisarea elementelor listei
        for (Book book : listaCarti) {
            System.out.println("for 2: " + book.toString());
        }

        //modalitate de parcurgere a listei folosind expresii lambda <- avansat si ne-necesar la momentul actual
        listaCarti.stream().forEach(book -> System.out.println("stream 3" + book.toString()));


        //modalitate de parcurgere a listei folosind iterator
        // si afisarea elementelor
        Iterator<Book> it = listaCarti.iterator();
        while (it.hasNext()) {
            Book book = it.next();
            System.out.println("iteartor " + book.toString());
        }

    }
}
