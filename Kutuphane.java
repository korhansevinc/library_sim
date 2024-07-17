import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

public class Kutuphane {

     HashMap<String,Integer> kayitlarInsan ;
     HashMap<String,Integer> kayitlarKitap ;


      public void topluKayit(ArrayList<Pair<String, String>> newKayitlar){
            kayitlarInsan = new HashMap<>();
            for(Pair<String, String> kayit : newKayitlar){
                  int kacKez = 0 ;
                  String tempName = kayit.getFirst();
                  for(Pair<String, String> kayit2 : newKayitlar){
                        if(tempName.equals(kayit2.getFirst())){
                              kacKez++;
                        }
                  }
                  kayitlarInsan.put(tempName, kacKez);
            }
            kayitlarKitap = new HashMap<>();
            for(Pair<String, String> kayit : newKayitlar){
                  int kacKez = 0 ;
                  String tempBookName = kayit.getSecond();
                  for(Pair<String, String> kayit2 : newKayitlar){
                        if(tempBookName.equals(kayit2.getSecond())){
                              kacKez++;
                        }
                  }
                  kayitlarKitap.put(tempBookName, kacKez);
            }

      }
      public void ozetGec() { 
            ArrayList<String> names = new ArrayList<>(kayitlarInsan.keySet());
            Collections.sort(names);
            for(String name : names){
                  System.out.println(name + "\t" + kayitlarInsan.get(name));
            }
      }

      public String enCokKitapOkuyan() {
      
            Iterator<Integer> it = kayitlarInsan.values().iterator();
            Integer max = 0 ;
            while(it.hasNext()){
                  Integer i = it.next();
                  if(i>max){
                        max = i ;
                  }
            }
            Iterator<String> it2 = kayitlarInsan.keySet().iterator();
            while(it2.hasNext()){
                  String tempStr = it2.next();
                  if(kayitlarInsan.get(tempStr) == max){
                       return tempStr ; 
                  }
            }
          return null ;
      }

      public String enAzOkunanKitap() {
            Iterator<Integer> it = kayitlarKitap.values().iterator();
            Integer min = it.next();
            while(it.hasNext()){
                  Integer i = it.next();
                  if(i<min){
                        min = i ;
                  }
            }

            Iterator<String> it2 = kayitlarKitap.keySet().iterator();
            while(it2.hasNext()){
                  String tempStr = it2.next();
                  if(kayitlarKitap.get(tempStr)==min){
                        return tempStr ;
                  }
            }
            return null;
      }

      public int toplamAlinanKitapSayisi() {
            Iterator<Integer> it = kayitlarKitap.values().iterator();
            Integer sum = 0 ;
            while(it.hasNext()){
                  sum = sum + it.next();
            }

            return sum;
      }

      public int toplamOkuyucuSayisi() {
            Iterator<String> it = kayitlarInsan.keySet().iterator();
            Integer sum = 0 ;
            while(it.hasNext()){
                  it.next();
                  sum++;
            }
            return sum;
      }
      
}
