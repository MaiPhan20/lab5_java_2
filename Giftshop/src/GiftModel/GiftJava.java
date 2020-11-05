package GiftModel;

public class GiftJava {
        private int id;
        private String name;
        private String author;
        private double price;
        private int qty;

        public GiftJava(int id, String name,String author,double price, int qty) {
            this.id = id;
            this.name = name;
            this.author=author;
            this.price = price;
            this.qty = qty;
        }
        public GiftJava(){
            this.id= 0;
            this.name="";
            this.author="";
            this.price= 0;
            this.qty= 0;
        }

        public String getName() {
            return name;
        }

        public int getQty() {
            return qty;
        }

        public double getPrice() {
            return price;
        }

        public int getId() {
            return id;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }

        public void setId(int id) {
            this.id = id;
        }
}
