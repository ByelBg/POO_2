package banco_de_dados;

import banco_de_dados.model.Cidade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.SplittableRandom;

public class CidadeService {

    public static int insereCidade(Cidade c) {
        try {
            Connection conn = Conexao.concectaMySql();

            String sql = "insert into cidade (nome,uf) values(?,?)";

            PreparedStatement pr = conn.prepareStatement(sql);
            pr.setString(1, c.getNome());
            pr.setString(2, c.getUf());
            int total = pr.executeUpdate();
            conn.close();
            return total;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
        public static int alteraCidade(Cidade c){
            try {
                Connection conn = Conexao.concectaMySql();

                String sql = "update cidade set nome=?, uf=? where idcidade=?";

                PreparedStatement pr = conn.prepareStatement(sql);
                pr.setString(1, c.getNome());
                pr.setString(2, c.getUf());
                pr.setInt(3, c.getIdcidade());
                int total = pr.executeUpdate();
                conn.close();
                return total;
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }
    public static int excluiCidade(Cidade c){
        try {
            Connection conn = Conexao.concectaMySql();

            String sql = "delete from cidade where idcidade=?";

            PreparedStatement pr = conn.prepareStatement(sql);
            pr.setInt(1, c.getIdcidade());
            int total = pr.executeUpdate();
            conn.close();
            return total;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public static ArrayList<Cidade> listAll(){
        ArrayList<Cidade> lista = new ArrayList<>();
        try{
            Connection conn = Conexao.concectaMySql();

            String sql = "select * from cidade";

            PreparedStatement pr = conn.prepareStatement(sql);
            ResultSet rs = pr.executeQuery();
            while (rs.next()){
                Cidade c = new Cidade();
                c.setIdcidade(rs.getInt("idcidade"));
                c.setNome(rs.getString("nome"));
                c.setUf(rs.getString("uf"));
                lista.add(c);
            }
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return lista;
    }

    public static Cidade findById(int id) {
        Cidade c = new Cidade();
        try {

            Connection conn = Conexao.concectaMySql();

            String sql = "select * from cidade where cidadeId = ?";

            PreparedStatement pr = conn.prepareStatement(sql);
            pr.setInt(1, id);
            ResultSet rs = pr.executeQuery();
            while (rs.next()) {
                c.setIdcidade(rs.getInt("idcidade"));
                c.setNome(rs.getString("nome"));
                c.setUf(rs.getString("uf"));
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return c;
    }

    public static int limpaTblCidade(){
        try {
            Connection conn = Conexao.concectaMySql();

            String sql = "delete from cidade where idcidade>0";

            PreparedStatement pr = conn.prepareStatement(sql);
            int total = pr.executeUpdate();

            sql = "alter table cidade auto_increment = 0";

            pr = conn.prepareStatement(sql);
            pr.executeUpdate();

            conn.close();
            return total;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

}
