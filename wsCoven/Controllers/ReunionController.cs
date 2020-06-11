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
    public class ReunionController : ApiController
    {

        private CovenEntities context = new CovenEntities();

        [HttpPost]
        public HttpResponseMessage Insert(ReunionModel _reunion)
        {
            try
            {
                #region Verificación de datos
                if (_reunion == null)
                    throw new Exception("No se recibio informacion");

                if (_reunion.fecha == null)
                    throw new Exception("Falta el parametro: fecha");

                if (_reunion.nombreLugar == null)
                    throw new Exception("Falta el parametro: nombreLugar");

                if (_reunion.latitud == null)
                    throw new Exception("Falta el parametro: latitud");

                if (_reunion.longitud == null)
                    throw new Exception("Falta el parametro: longitud");

                if (_reunion.usuario_id == null)
                    throw new Exception("Falta el parametro: usuario_id");
                #endregion

                #region Insertar usuario en la BD

                TB_Reunion reunion = new TB_Reunion
                {
                    fecha = _reunion.fecha,
                    nombreLugar = _reunion.nombreLugar,
                    latitud = _reunion.latitud,
                    longitud = _reunion.longitud,
                    usuario_id = _reunion.usuario_id
                };

                context.TB_Reunion.Add(reunion);
                context.SaveChanges();

                #endregion

                return Request.CreateResponse(HttpStatusCode.OK, new { mensaje = "Reunion creada exitosamente" });
            }
            catch (Exception ex)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensaje = "Error al insertar Reunion: " + ex.Message });
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
                ReunionModel reunion = (from tReunion in context.TB_Reunion
                                        where tReunion.id_Reunion == _id
                                        select new ReunionModel
                                        {
                                            id_Reunion = tReunion.id_Reunion,
                                            fecha = tReunion.fecha,
                                            nombreLugar = tReunion.nombreLugar,
                                            latitud = tReunion.latitud,
                                            longitud = tReunion.longitud,
                                            usuario_id = tReunion.usuario_id
                                        }).FirstOrDefault();
                #endregion

                return Request.CreateResponse(HttpStatusCode.OK, reunion);
            }
            catch (Exception ex)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensaje = "Error al seleccionar Reunion: " + ex.Message });
            }
        }

        [HttpGet]
        public HttpResponseMessage ShowReunionesUsuario(int _id = 0)
        {
            try
            {
                #region Verificación de datos
                if (_id == 0)
                    throw new Exception("No se recibio un id");
                #endregion

                #region Buscar registro en la BD
                IEnumerable<ReunionModel> reuniones  = (from tReunion in context.TB_Reunion
                                        where tReunion.usuario_id == _id
                                        select new ReunionModel
                                        {
                                            id_Reunion = tReunion.id_Reunion,
                                            fecha = tReunion.fecha,
                                            nombreLugar = tReunion.nombreLugar,
                                            latitud = tReunion.latitud,
                                            longitud = tReunion.longitud,
                                            usuario_id = tReunion.usuario_id
                                        });
                #endregion

                return Request.CreateResponse(HttpStatusCode.OK, reuniones);
            }
            catch (Exception ex)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensaje = "Error al seleccionar Reunion: " + ex.Message });
            }
        }

        [HttpGet]
        public HttpResponseMessage Select()
        {
            try
            {
                #region Buscar reuniones en la BD
                IEnumerable<ReunionModel> reuniones = (from tReunion in context.TB_Reunion
                                                       select new ReunionModel
                                                       {
                                                           id_Reunion = tReunion.id_Reunion,
                                                           fecha = tReunion.fecha,
                                                           nombreLugar = tReunion.nombreLugar,
                                                           latitud = tReunion.latitud,
                                                           longitud = tReunion.longitud,
                                                           usuario_id = tReunion.usuario_id
                                                       });
                #endregion

                return Request.CreateResponse(HttpStatusCode.OK, reuniones);
            }
            catch (Exception ex)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensaje = "Error al seleccionar Reuniones: " + ex.Message });
            }
        }
    }
}
