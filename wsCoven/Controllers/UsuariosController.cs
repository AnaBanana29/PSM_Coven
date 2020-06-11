using System;
using System.Data;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using wsCoven.Models.DAL;
using wsCoven.Models.DAO;
using System.Transactions;
using System.Web.Http.Cors;

namespace wsCoven.Controllers
{
    public class UsuariosController : ApiController
    {
        private CovenEntities context = new CovenEntities();

        [HttpPost]
        public HttpResponseMessage Insert(UsuariosModel _usuario)
        {
            try
            {
                #region Verificación de datos
                if (_usuario == null)
                    throw new Exception("No se recibio informacion");

                if (_usuario.nombreUsuario == null)
                    throw new Exception("Falta el parametro: nombreUsuario");

                if (_usuario.nombre == null)
                    throw new Exception("Falta el parametro: nombre");

                if (_usuario.apellidos == null)
                    throw new Exception("Falta el parametro: apellidos");

                if (_usuario.correo == null)
                    throw new Exception("Falta el parametro: correo");

                if (_usuario.contrasena == null)
                    throw new Exception("Falta el parametro: contrasena");
                #endregion

                #region Insertar usuario en la BD

                TB_Usuario usuario = new TB_Usuario
                {
                    nombreUsuario = _usuario.nombreUsuario,
                    nombre = _usuario.nombre,
                    apellidos = _usuario.apellidos,
                    correo = _usuario.correo,
                    contrasena = _usuario.contrasena
                };

                context.TB_Usuario.Add(usuario);
                context.SaveChanges();

                #endregion

                return Request.CreateResponse(HttpStatusCode.OK, new { mensaje = "Usuario creado exitosamente" });
            }
            catch (Exception ex)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensaje = "Error al insertar Usuario: " + ex.Message });
            }
        }

        [HttpGet]
        public HttpResponseMessage Login(string _usuario, string _contrasena)
        {
            using (TransactionScope scope = new TransactionScope())
            {
                try
                {
                    #region Verificación de datos
                    if (_usuario == null)
                        throw new Exception("No se recibio un usuario");

                    if (_contrasena == null)
                        throw new Exception("No se recibio una contraseña");
                    #endregion

                    #region Verifica que exista el usuario
                    UsuariosModel usuario = (from tUsuario in context.TB_Usuario
                                             where (tUsuario.nombreUsuario == _usuario) || (tUsuario.correo == _usuario)
                                             select new UsuariosModel
                                             {
                                                 id_Usuario = tUsuario.id_Usuario,
                                                 nombreUsuario = tUsuario.nombreUsuario,
                                                 nombre = tUsuario.nombre,
                                                 apellidos = tUsuario.apellidos,
                                                 correo = tUsuario.correo,
                                                 contrasena = tUsuario.contrasena
                                             }).FirstOrDefault();

                    if (usuario == null)
                        throw new Exception("El usuario " + _usuario + " no existe");
                    #endregion

                    #region Revisar que la contraseña esté correcta
                    if (usuario.contrasena != _contrasena)
                        throw new Exception("Contraseña incorrecta");
                    #endregion

                    scope.Complete();

                    return Request.CreateResponse(HttpStatusCode.OK, usuario);
                }
                catch (Exception ex)
                {
                    scope.Dispose();
                    return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensaje = "Error al ingresar: " + ex.Message });
                }
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

                #region Buscar usuario en la BD
                UsuariosModel usuario = (from tUsuario in context.TB_Usuario
                                         where tUsuario.id_Usuario == _id
                                         select new UsuariosModel
                                         {
                                             id_Usuario = tUsuario.id_Usuario,
                                             nombreUsuario = tUsuario.nombreUsuario,
                                             nombre = tUsuario.nombre,
                                             apellidos = tUsuario.apellidos,
                                             correo = tUsuario.correo,
                                             contrasena = tUsuario.contrasena
                                         }).FirstOrDefault();
                #endregion

                return Request.CreateResponse(HttpStatusCode.OK, usuario);
            }
            catch (Exception ex)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensaje = "Error al seleccionar Usuario: " + ex.Message });
            }
        }

        [HttpGet]
        public HttpResponseMessage Select()
        {
            try
            {
                #region Buscar usuario en la BD
                IEnumerable<UsuariosModel> usuarios = (from tUsuario in context.TB_Usuario
                                         select new UsuariosModel
                                         {
                                             id_Usuario = tUsuario.id_Usuario,
                                             nombreUsuario = tUsuario.nombreUsuario,
                                             nombre = tUsuario.nombre,
                                             apellidos = tUsuario.apellidos,
                                             correo = tUsuario.correo,
                                             contrasena = tUsuario.contrasena
                                         });
                #endregion

                return Request.CreateResponse(HttpStatusCode.OK, usuarios);
            }
            catch (Exception ex)
            {
                return Request.CreateResponse(HttpStatusCode.BadRequest, new { mensaje = "Error al seleccionar Usuarios: " + ex.Message });
            }
        }


    }
}
