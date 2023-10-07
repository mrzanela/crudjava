import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class ContatoDAO {
    
    public void save(Contato contato){
        String sql =  "INSERT INTO contatos(nome, idade, dataCadastro) values (?,?,?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try{
            conn = ConnectionFactory.createConnectionToMySQL();

            pstm = (PreparedStatement) conn.prepareStatement(sql);
            pstm.setString(1, contato.getNome());
            pstm.setInt(2, contato.getIdade());
            pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

            pstm.execute();
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                if (pstm!=null) {
                    pstm.close();
                }
                if (conn!=null) {
                    conn.close();
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}