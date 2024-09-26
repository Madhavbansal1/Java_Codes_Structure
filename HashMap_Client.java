public class HashMap_Client {
    public static void main(String[] args) {
        HashMap_Implementation<String,Integer> map = new HashMap_Implementation<>();
        map.put("Kamlesh", 77);
        map.put("Amisha", 69);
        map.put("Raj", 59);
        map.put("Ankit", 67);
        map.put("Puneet", 78);
        map.put("Shivani", 47);
        map.put("Ankit", 167);
        System.out.println(map.contains("Shivani"));
        System.out.println(map.contains("Shivana"));
        System.out.println(map.get("Ankit"));
        System.out.println(map.get("Ankita"));
        System.out.println(map);
        System.out.println(map.remove("Ankit"));
        System.out.println(map);
    }
}
