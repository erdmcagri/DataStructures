package veriyapilaridonemprojesi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class veriproje extends javax.swing.JFrame {

    public veriproje() {
        initComponents();
        JOptionPane.showMessageDialog(null, "Text içerisine rakam giriniz. ");
        setTitle("Movie Recommendation System");
        listeDoldur();
    }

    ArrayList<Client> users = new ArrayList();
    ArrayList<Movie> movie = new ArrayList();
    DefaultListModel izlenen = new DefaultListModel();//jListleri doldurmak için oluşturduk
    DefaultListModel benzer = new DefaultListModel();
    DefaultListModel onerilen = new DefaultListModel();

    void listeDoldur() {//movieleri ve clientlerin dosyalarındaki bilgileri alıp yukarda oluşturduğumuz array listlere atacak
        String satir;
        String client;
        String satir1;
        try {
            BufferedReader oku1 = new BufferedReader(new FileReader("movie_idmap.txt"));
            while ((satir1 = oku1.readLine()) != null) {//null olana kadar satır satır okuma işlemi
                int movieID = Integer.parseInt(satir1.substring(satir1.indexOf("m") + 1, satir1.indexOf(" ")).trim()); //dosyadan movie id lerini at
                String movieName = satir1.substring(satir1.indexOf(" ")).trim();//dosyadan movie namelerini at
                movie.add(new Movie(movieID, movieName));//movie clasındaki parametreleri girdik

            }
            oku1.close();
        } catch (IOException ıox) {
            JOptionPane.showMessageDialog(this, "Dosya Okunamıyor");
        }

        try {
            BufferedReader oku = new BufferedReader(new FileReader("client-preference.txt"));

            while ((satir = oku.readLine()) != null) {
                client = satir.substring(satir.indexOf("c"), satir.indexOf("m")).trim();
                if (users.size() <= Integer.parseInt(client.substring(1))) {
                    users.add(new Client(Integer.parseInt(client.substring(1))));
                }
                users.get(Integer.parseInt(client.substring(1))).array.add(new Movie(Integer.parseInt(satir.substring(satir.indexOf("m") + 1)), movie.get(Integer.parseInt(satir.substring(satir.indexOf("m") + 1))).name));

            }
            oku.close();
        } catch (IOException ıox) {
            JOptionPane.showMessageDialog(this, "Dosya Okunamıyor");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(700, 615));
        setResizable(false);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/veriyapilaridonemprojesi/xxx.png"))); // NOI18N

        jPanel1.setBackground(new java.awt.Color(28, 42, 54));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton1.setText("Recommend");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jList1);

        jScrollPane2.setViewportView(jList2);

        jScrollPane3.setViewportView(jList3);

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Eleman Sayısı");

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Eleman Sayısı");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(63, 63, 63)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField1)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(7, 7, 7)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       izlenen.removeAllElements();
        try {
            int i = Integer.parseInt(jTextField1.getText());
            for (int j = 0; j < users.get(i).array.size(); j++) {
                izlenen.addElement(users.get(i).array.get(j).name);
            }
        } catch (IndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Böyle Bir Kullanıcı Bulunmamaktadır.");
        }
        jList1.setModel(izlenen);
        jLabel3.setText(String.valueOf(izlenen.size()));
        insertionSort(benzerFilmler());
        recommendation();  
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new veriproje().setVisible(true);
            }
        });
    }

    String[] benzerFilmler() {
        int client = Integer.parseInt(jTextField1.getText());//12
        String[] benzer = new String[100];
        int sayac;
        for (int i = 0; i < 100; i++) {//clientları geziyo
            sayac = 0;
            if (i == client) {
                benzer[i] = users.get(i).array.size() + "\n" + sayac;
            } else {
                for (int j = 0; j < users.get(client).array.size(); j++) {
                    for (int k = 0; k < users.get(i).array.size(); k++) {
                        if ((users.get(client).array.get(j).id) == (users.get(i).array.get(k).id)) {
                            sayac++;
                        }
                    }
                }
                benzer[i] = users.get(i).id + "\n" + sayac;
            }
        }
        return benzer;
    }

    void insertionSort(String[] dizi) {
        benzer.removeAllElements();
        int client = Integer.parseInt(jTextField1.getText());
        for (int i = 0; i < dizi.length; i++) {
            String movies = dizi[i].substring(0, dizi[i].indexOf("\n"));
            int sayac = Integer.parseInt(dizi[i].substring(dizi[i].indexOf("\n") + 1));
            int j;
            for (j = i; j > 0 && sayac < Integer.parseInt(dizi[j - 1].substring(dizi[j - 1].indexOf("\n") + 1)); j--) {
                dizi[j] = dizi[j - 1];
            }
            dizi[j] = movies + "\n" + Integer.toString(sayac);
        }
        for (int i = dizi.length - 1; i > 0; i--) {
            if (client == i) {
                //continue;
            } else {
                benzer.addElement(users.get(client).id + "-" + dizi[i].substring(0, dizi[i].indexOf("\n")) + " Benzer = " + dizi[i].substring(dizi[i].indexOf("\n") + 1));
            }
        }
        jList2.setModel(benzer);
    }

    void recommendation() {
        onerilen.removeAllElements();
        int client1 = Integer.parseInt(jTextField1.getText());
        String c2 = (String) benzer.get(0);
        int client2 = Integer.parseInt(c2.substring(c2.indexOf("-") + 1, c2.indexOf(" ")));
        for (int j = 0; j < users.get(client1).array.size(); j++) {
            boolean buldumu = false;
            for (int k = 0; k < users.get(client2).array.size(); k++) {
                int a = (users.get(client1).array.get(j).id);
                int b = (users.get(client2).array.get(k).id);
                if (a == b) {
                    buldumu = true;
                }
            }
            if (buldumu == false) {
                onerilen.addElement(users.get(client2).array.get(j).name);
            }
        }
        jList3.setModel(onerilen);
        jLabel4.setText(""+onerilen.size());
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JList jList3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
