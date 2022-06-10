package services.dataGenerator;

import DTO_STORE.Store;
public class StoreGenerator {
    private static String id = "0";

    public static Store getStore() {
//        id++;
        return Store.builder()
                .id(id)
                .petId(0)
                .quantity(0)
                .shipDate("2022-05-27T12:02:21.155+0000")
                .status("Placed")
                .complete(true)
                .build();

   }
   public static Store getIventory(){
        return Store.builder()
                .id(id)
                .build();
   }
}

