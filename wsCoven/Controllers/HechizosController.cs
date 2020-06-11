using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using wsCoven.Models.DAL;
using wsCoven.Models.DAO;

namespace wsCoven.Controllers
{
    public class HechizosController : ApiController
    {
        private CovenEntities context = new CovenEntities();

        [HttpPost]
        public HttpResponseMessage Insert(HechizosModel _hechizo)
        {
            try
            {
                #region Verificación de datos
                if (_hechizo == null)
                    throw new Exception("No se recibio informacion");

                if (_hechizo.titulo == null)
                    throw new Exception("Falta el parametro: titulo");

                if (_hechizo.descripcion == null)
                    throw new Exception("Falta el parametro: descripcion");

                if (_hechizo.usuario_id == null)
                    throw new Exception("Falta el parametro: usuario_id");
                #endregion

                #region Insertar usuario en la BD

                TB_Hechizo reunion = new TB_Hechizo
                {
                    titulo = _hechizo.titulo,
                    descripcion = _hechizo.descripcion,
                    likes = 0,
                    usuario_id = _hechizo.usuario_id
                };

                context.TB_Hechizo.Add(reunion);
                context.SaveChanges();

                #endregion

                return Request.CreateResponse(HttpStatusCode.OK, new { mensaje = "Hechizo creada exitosamente" });
            }
            catch (Exception ex)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensaje = "Error al insertar Hechizo: " + ex.Message });
            }
        }

        [HttpGet]
        public HttpResponseMessage Show(int _id = 0)
        {
            try
            {
                #region Verificación de datos
                if (_id == 0)
                    throw new Exception("No se recibio un id");
                #endregion

                #region Buscar registro en la BD
                HechizosModel hechizo = (from tHechizo in context.TB_Hechizo
                                         where tHechizo.id_Hechizo == _id
                                         select new HechizosModel
                                         {
                                             id_Hechizo = tHechizo.id_Hechizo,
                                             titulo = tHechizo.titulo,
                                             descripcion = tHechizo.descripcion,
                                             likes = tHechizo.likes,
                                             usuario_id = tHechizo.usuario_id,
                                         }).FirstOrDefault();
                #endregion

                return Request.CreateResponse(HttpStatusCode.OK, hechizo);
            }
            catch (Exception ex)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensaje = "Error al seleccionar Hechizo: " + ex.Message });
            }
        }

        [HttpGet]
        public HttpResponseMessage Select()
        {
            try
            {
                #region Buscar registro en la BD
                IEnumerable <HechizosModel> hechizo = (from tHechizo in context.TB_Hechizo
                                         select new HechizosModel
                                         {
                                             id_Hechizo = tHechizo.id_Hechizo,
                                             titulo = tHechizo.titulo,
                                             descripcion = tHechizo.descripcion,
                                             likes = tHechizo.likes,
                                             usuario_id = tHechizo.usuario_id,
                                         });
                #endregion

                return Request.CreateResponse(HttpStatusCode.OK, hechizo);
            }
            catch (Exception ex)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensaje = "Error al seleccionar Hechizo: " + ex.Message });
            }
        }

        [HttpPut]
        public HttpResponseMessage AddLike(int _id = 0)
        {
            try
            {
                #region Verificación de datos
                if (_id == 0)
                    throw new Exception("No se recibio un id");
                #endregion

                #region Revisa que exista el registro
                TB_Hechizo hechizo = (from tHechizo in context.TB_Hechizo
                                      where tHechizo.id_Hechizo == _id
                                      select tHechizo).FirstOrDefault();

                if(hechizo == null)
                    throw new Exception("No existe ese registro");
                #endregion

                hechizo.likes++;
                context.SaveChanges();

                return Request.CreateResponse(HttpStatusCode.OK, "Like Agregado");
            }
            catch (Exception ex)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensaje = "Error al seleccionar Hechizo: " + ex.Message });
            }
        }
    }
}
