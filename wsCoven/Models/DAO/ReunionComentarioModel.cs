using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace wsCoven.Models.DAO
{
    public class ReunionComentarioModel
    {
        public int id_ReunionComentario { get; set; }
        public string contenido { get; set; }
        public Nullable<System.DateTime> fecha { get; set; }
        public Nullable<int> usuario_id { get; set; }
        public Nullable<int> reunion_id { get; set; }
    }
}