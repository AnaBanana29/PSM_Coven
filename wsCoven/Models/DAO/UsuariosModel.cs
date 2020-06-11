using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace wsCoven.Models.DAO
{
    public class UsuariosModel
    {
        public int id_Usuario { get; set; }
        public string nombreUsuario { get; set; }
        public string nombre { get; set; }
        public string apellidos { get; set; }
        public string correo { get; set; }
        public string contrasena { get; set; }
    }
}