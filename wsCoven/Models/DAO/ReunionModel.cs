using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace wsCoven.Models.DAO
{
    public class ReunionModel
    {
        public int id_Reunion { get; set; }
        public Nullable<System.DateTime> fecha { get; set; }
        public string nombreLugar { get; set; }
        public Nullable<double> latitud { get; set; }
        public Nullable<double> longitud { get; set; }
        public Nullable<int> usuario_id { get; set; }
    }
}