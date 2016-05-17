using LojaNinja.Dominio;
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
        string connectionString = ConfigurationManager.ConnectionStrings["ConexaoBanco"].ConnectionString;

        public Usuario BuscarUsuarioPorAutenticacao(string email, string senha)
        {
            using (var conexao = new SqlConnection(connectionString))
            {
                string sql = "SELECT * FROM USUARIO WHERE email=@p_email and senha=@p_senha";
                var usuario = new Usuario();
                var comando = new SqlCommand(sql, conexao);
                comando.Parameters.Add(new SqlParameter("p_email", email));
                comando.Parameters.Add(new SqlParameter("p_senha", senha));

                conexao.Open();

                SqlDataReader leitor = comando.ExecuteReader();

                if (leitor.Read())
                {
                    var id = (int)leitor["UsuarioId"];
                    usuario = new Usuario
                    {
                        Id = id,
                        Email = (string)leitor["Email"],
                        Nome = (string)leitor["Nome"],
                        Senha = (string)leitor["Senha"],
                        Permissoes = VerificarPermissoesDeUsuario(id)
                    };

                }
                return usuario;
            }


        }
        private List<string> VerificarPermissoesDeUsuario(int id)
        {
            using (var conexao = new SqlConnection(connectionString))
            {
                string sql = "SELECT Permissao.Permissao from Permissao join UsuarioPermissao on Permissao.PermissaoId = UsuarioPermissao.PermissaoId and UsuarioPermissao.UsuarioId = @p_id";
                var comando = new SqlCommand(sql, conexao);
                comando.Parameters.Add(new SqlParameter("p_id", id));
                conexao.Open();
                SqlDataReader leitor = comando.ExecuteReader();
                List<string> permissoes = new List<string>();
                while (leitor.Read())
                {
                    var permissao = (string)leitor["Permissao"];
                    permissoes.Add(permissao);
                }
                return permissoes;
            }

        }

        public void InserirUsuario(Usuario usuario)
        {
            using (var conexao = new SqlConnection(connectionString))
            {
                string sql = "INSERT INTO Usuario(Nome,Email,Senha) VALUES (@p_nome,@p_email,@p_senha)";
                var comando = new SqlCommand(sql, conexao);
                comando.Parameters.Add(new SqlParameter("p_nome", usuario.Nome));
                comando.Parameters.Add(new SqlParameter("p_email", usuario.Email));
                comando.Parameters.Add(new SqlParameter("p_senha", usuario.Senha));
                conexao.Open();
                SqlDataReader leitor = comando.ExecuteReader();

            }
        }
        //TODO:
        private void SetarPermissoesDoUsuario(string email)
        {
            using (var conexao = new SqlConnection(connectionString))
            {
                //string sql = ""
            }
        }
    }
}
