using Dominio;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Repositorio
{
    public class UsuarioRepositorioADO : IUsuarioRepositorio
    {
        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            string connectionString = ConfigurationManager.ConnectionStrings["ConexaoBanco"].ConnectionString;
            using (var conexao = new SqlConnection(connectionString))
            {
                string sql = "SELECT * FROM Usuarios WHERE email=@p_email and senha=@p_senha";
                var usuario = new Usuario();
                var comando = new SqlCommand(sql, conexao);
                comando.Parameters.Add(new SqlParameter("p_email", email));
                comando.Parameters.Add(new SqlParameter("p_senha", senha));

                conexao.Open();

                SqlDataReader leitor = comando.ExecuteReader();
                
                if(leitor.Read())
                {
                   usuario = new Usuario
                        {
                            Email = (string)leitor["email"],
                            Nome = (string)leitor["nome"],
                            Senha = (string)leitor["senha"]
                        };
                                       
                }
                return usuario;
           }


        }
    }
}
