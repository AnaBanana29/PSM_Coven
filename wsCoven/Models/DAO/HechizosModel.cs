using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace wsCoven.Models.DAO
{
    public class HechizosModel
    {
        public int id_Hechizo { get; set; }
        public string titulo { get; set; }
        public string descripcion { get; set; }
        public int likes { get; set; }
        public Nullable<int> usuario_id { get; set; }
    }
}