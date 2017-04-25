package proje1_05140010136;

import java.util.Scanner;

public class Proje1_05140010136 {

    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        char option = 0;
        double[] ortalamaPuan;
        Reports rapor = new Reports();
        rapor.dosyaOku("Firma.txt");

        System.out.println("[1] Ürünlerin ortalama derecelendirme puanı");
        System.out.println("[2] Ulusal müşterilere göre ürünlerin ortalama derecelendirme puanı");
        System.out.println("[3] Uluslararası müşterilere göre ürünlerin ortalama derecelendirme puanı");
        System.out.println("[4] Ulusal müşterilerden mesleği doktor olanlara göre ürünlerin ortalama derecelendirme puanı");
        System.out.println("[5] Her bir ürün için o ürüne ait ortalama derecelendirmenin altında puan vermiş ulusal müşterilerin bilgileri");
        System.out.println("[6] Her bir ürün için o ürüne ait ortalama derecelendirmenin altında puan vermiş uluslararası müşterilerin bilgileri");
        System.out.println("[7] Müşteri girişi");
        System.out.println("[8] Klavyeden girilen müşterilerin listesi ve ortalama derecelendirme puanları");
        System.out.println("[c] Çıkış");
        do {

            System.out.print("\nSeçim :");
            option = sc.nextLine().charAt(0);

            switch (option) {
                case '1':
                    System.out.println("[1] Ürünlerin ortalama derecelendirme puanı");
                    ortalamaPuan = rapor.urunlerinOrtalamaPuani();
                    rapor.ortalamaEkranaYaz(ortalamaPuan, "A\tB\tC\tD\tE\t");
                    break;
                case '2':
                    System.out.println("[2] Ulusal müşterilere göre ürünlerin ortalama derecelendirme puanı");
                    double[] ortalamaPuanUlusal = rapor.urunlerinOrtalamaPuani(new NationalCustomer());
                    rapor.ortalamaEkranaYaz(ortalamaPuanUlusal, "A\tB\tC\tD\tE\t");
                    break;
                case '3':
                    System.out.println("[3] Uluslararası müşterilere göre ürünlerin ortalama derecelendirme puanı");
                    double[] ortalamaPuanUluslararasi = rapor.urunlerinOrtalamaPuani(new InternationalCustomer());
                    rapor.ortalamaEkranaYaz(ortalamaPuanUluslararasi, "A\tB\tC\tD\tE\t");
                    break;
                case '4':
                    System.out.println("[4] Ulusal müşterilerden mesleği doktor olanlara göre ürünlerin ortalama derecelendirme puanı");
                    rapor.ortalamaEkranaYaz(rapor.urunlerinOrtalamaPuani("Doktor"), "A\tB\tC\tD\tE\t");
                    break;
                case '5':
                    ortalamaPuan = rapor.urunlerinOrtalamaPuani();
                    System.out.println("[5] Her bir ürün için o ürüne ait ortalama derecelendirmenin altında puan vermiş ulusal müşterilerin bilgileri");
                    rapor.dereceKarsilastir(new NationalCustomer(), ortalamaPuan);
                    break;
                case '6':
                    ortalamaPuan = rapor.urunlerinOrtalamaPuani();
                    System.out.println("[6] Her bir ürün için o ürüne ait ortalama derecelendirmenin altında puan vermiş uluslararası müşterilerin bilgileri");
                    rapor.dereceKarsilastir(new InternationalCustomer(), ortalamaPuan);
                    System.out.println("-----------------------------");
                    break;
                case '7':
                    rapor.musteriGirisi();
                    break;
                case '8':
                    System.out.println("Klavyeden girilen müşterilerin listesi :");
                    rapor.girisYapilanMusteriler();
                    System.out.println("--------------------------------");
                    System.out.println("Klavyeden girilen müşterilerin ortalama puanları :");
                    ortalamaPuan = rapor.urunlerinOrtalamaPuani(rapor.fileCustomerCount());
                    rapor.ortalamaEkranaYaz(ortalamaPuan, "A\tB\tC\tD\tE\t");
                    break;
                default:
                    break;
            }
        } while (!(option == 'c' || option == 'C'));

    }
}
