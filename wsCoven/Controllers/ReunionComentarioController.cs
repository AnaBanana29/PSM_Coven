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
    public class ReunionComentarioController : ApiController
    {

        private CovenEntities context = new CovenEntities();

        [HttpPost]
        public HttpResponseMessage Insert(ReunionComentarioModel _reunionComentario)
        {
            try
            {
                #region Verificación de datos
                if (_reunionComentario == null)
                    throw new Exception("No se recibio informacion");

                if (_reunionComentario.contenido == null)
                    throw new Exception("Falta el parametro: contenido");

                if (_reunionComentario.usuario_id == null)
                    throw new Exception("Falta el parametro: usuario_id");

                if (_reunionComentario.reunion_id == null)
                    throw new Exception("Falta el parametro: reunion_id");
                #endregion

                #region Insertar usuario en la BD

                TB_ReunionComentario reunionComentario = new TB_ReunionComentario
                {
                    contenido = _reunionComentario.contenido,
                    fecha = DateTime.Now,
                    usuario_id = _reunionComentario.usuario_id,
                    reunion_id = _reunionComentario.reunion_id
                };

                context.TB_ReunionComentario.Add(reunionComentario);
                context.SaveChanges();

                #endregion

                return Request.CreateResponse(HttpStatusCode.OK, new { mensaje = "Comentarios creada exitosamente" });
            }
            catch (Exception ex)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensaje = "Error al insertar Comentario: " + ex.Message });
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
                ReunionComentarioModel reunionComentario = (from tReunionComentario in context.TB_ReunionComentario
                                         where tReunionComentario.id_ReunionComentario == _id
                                         select new ReunionComentarioModel
                                         {
                                             id_ReunionComentario = tReunionComentario.id_ReunionComentario,
                                             contenido = tReunionComentario.contenido,
                                             fecha = tReunionComentario.fecha,
                                             usuario_id = tReunionComentario.usuario_id,
                                             reunion_id = tReunionComentario.reunion_id,
                                         }).FirstOrDefault();
                #endregion

                return Request.CreateResponse(HttpStatusCode.OK, reunionComentario);
            }
            catch (Exception ex)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensaje = "Error al seleccionar Comentario: " + ex.Message });
            }
        }

        [HttpGet]
        public HttpResponseMessage Select()
        {
            try
            {
                #region Buscar reuniones en la BD
                IEnumerable<ReunionComentarioModel> reuniones = (from tReunionComentario in context.TB_ReunionComentario
                                                       select new ReunionComentarioModel
                                                       {
                                                           id_ReunionComentario = tReunionComentario.id_ReunionComentario,
                                                           contenido = tReunionComentario.contenido,
                                                           fecha = tReunionComentario.fecha,
                                                           usuario_id = tReunionComentario.usuario_id,
                                                           reunion_id = tReunionComentario.reunion_id,
                                                       });
                #endregion

                return Request.CreateResponse(HttpStatusCode.OK, reuniones);
            }
            catch (Exception ex)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensaje = "Error al seleccionar Comentarios: " + ex.Message });
            }
        }
    }
}
