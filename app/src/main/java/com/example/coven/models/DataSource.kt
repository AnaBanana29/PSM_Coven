package com.example.coven.models

import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList

class DataSource {

    companion object{

        fun createDataSetEvento(): ArrayList<EventoModel>{
            val list = ArrayList<EventoModel>()
            //region datos
            list.add(
                EventoModel(
                    1,
                    "Sabrina",
                    "Conmemoración de Salem",
                    "Todas las brujas están invitadas a la reunión convocada para recordar a nuestras hermanas juzgadas",
                    123F,
                    123F,
                    1
                )
            )
            list.add(
                EventoModel(
                    2,
                    "LadyNight",
                    "Meditación en Grupo",
                    "Todas las brujas están invitadas a la reunión convocada para recordar a nuestras hermanas juzgadas",
                    123F,
                    123F,
                    1
                )
            )
            list.add(
                EventoModel(
                    3,
                    "AnaValdes",
                    "Bailar en la hoguera",
                    "Todas las brujas están invitadas a la reunión convocada para recordar a nuestras hermanas juzgadas",
                    123F,
                    123F,
                    1
                )
            )
            list.add(
                EventoModel(
                    4,
                    "RisaSardonica",
                    "Llamado al Baphomet",
                    "Todas las brujas están invitadas a la reunión convocada para recordar a nuestras hermanas juzgadas",
                    123F,
                    123F,
                    1
                )
            )
            list.add(
                EventoModel(
                    5,
                    "Sabrina",
                    "Conmemoración de Salem",
                    "Todas las brujas están invitadas a la reunión convocada para recordar a nuestras hermanas juzgadas",
                    123F,
                    123F,
                    1
                )
            )
            list.add(
                EventoModel(
                    6,
                    "Sabrina",
                    "Conmemoración de Salem",
                    "Todas las brujas están invitadas a la reunión convocada para recordar a nuestras hermanas juzgadas",
                    123F,
                    123F,
                    1
                )
            )
            list.add(
                EventoModel(
                    7,
                    "LadyNight",
                    "Meditación en Grupo",
                    "Todas las brujas están invitadas a la reunión convocada para recordar a nuestras hermanas juzgadas",
                    123F,
                    123F,
                    1
                )
            )
            list.add(
                EventoModel(
                    8,
                    "AnaValdes",
                    "Bailar en la hoguera",
                    "Todas las brujas están invitadas a la reunión convocada para recordar a nuestras hermanas juzgadas",
                    123F,
                    123F,
                    1
                )
            )
            list.add(
                EventoModel(
                    9,
                    "RisaSardonica",
                    "Llamado al Baphomet",
                    "Todas las brujas están invitadas a la reunión convocada para recordar a nuestras hermanas juzgadas",
                    123F,
                    123F,
                    1
                )
            )
            list.add(
                EventoModel(
                    10,
                    "Sabrina",
                    "Conmemoración de Salem",
                    "Todas las brujas están invitadas a la reunión convocada para recordar a nuestras hermanas juzgadas",
                    123F,
                    123F,
                    1
                )
            )
            //endregion
            return list
        }

        fun createDataSetHechizo(): ArrayList<HechizoModel>{
            val list = ArrayList<HechizoModel>()
            //region datos
            list.add(
                HechizoModel(
                    1,
                    "Titulo 1",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    1,
                    "Sabrina"
                )
            )
            list.add(
                HechizoModel(
                    2,
                    "Titulo 2",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    11,
                    "Juan"
                )
            )
            list.add(
                HechizoModel(
                    3,
                    "Titulo 1",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    1,
                    "Sabrina"
                )
            )
            list.add(
                HechizoModel(
                    4,
                    "Titulo 1",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    56,
                    "Sabrina"
                )
            )
            list.add(
                HechizoModel(
                    1,
                    "Titulo 2",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    1,
                    "Juan"
                )
            )
            list.add(
                HechizoModel(
                    5,
                    "Titulo 1",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    1,
                    "Sabrina"
                )
            )
            list.add(
                HechizoModel(
                    6,
                    "Titulo 1",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    1,
                    "Sabrina"
                )
            )
            list.add(
                HechizoModel(
                    7,
                    "Titulo 2",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    1,
                    "Juan"
                )
            )
            list.add(
                HechizoModel(
                    8,
                    "Titulo 1",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    1,
                    "Sabrina"
                )
            )
            list.add(
                HechizoModel(
                    9,
                    "Titulo 2",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    1,
                    "Juan"
                )
            )
            list.add(
                HechizoModel(
                    10,
                    "Titulo 1",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.",
                    1,
                    "Sabrina"
                )
            )
            //endregion
            return list
        }

        fun createDataSetUsuario(): ArrayList<UsuarioModel>{
            var list = ArrayList<UsuarioModel>()
            //region datos
            list.add(
                UsuarioModel(
                    1,
                    "Sabrina",
                    "Sabrina",
                    "Spellman",
                    "sabrina@aol.com",
                    "666"
                )
            )
            list.add(
                UsuarioModel(
                    2,
                    "LaBelleIndifference",
                    "Regina",
                    "George",
                    "correo@aol.com",
                    "666"
                )
            )
            list.add(
                UsuarioModel(
                    3,
                    "thoth666",
                    "Aleister",
                    "Crowley",
                    "al.crow@aol.com",
                    "666"
                )
            )
            list.add(
                UsuarioModel(
                    4,
                    "moon_godess123",
                    "Betty",
                    "Parris",
                    "betty.p@aol.com",
                    "666"
                )
            )
            list.add(
                UsuarioModel(
                    5,
                    "EliphasLevi",
                    "Alphonse",
                    "Constant",
                    "eliphas@aol.com",
                    "666"
                )
            )
            //endregion
            return list
        }

        fun createDataSetPaginarimorio(): ArrayList<PaginaGrimorioModel>{
            var list = ArrayList<PaginaGrimorioModel>()

            //region Datos
            list.add(
                PaginaGrimorioModel(
                    "Titulo",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
                )
            )
            list.add(
                PaginaGrimorioModel(
                    "Titulo",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
                )
            )
            list.add(
                PaginaGrimorioModel(
                    "Titulo",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
                )
            )
            list.add(
                PaginaGrimorioModel(
                    "Titulo",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
                )
            )
            list.add(
                PaginaGrimorioModel(
                    "Titulo",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
                )
            )
            list.add(
                PaginaGrimorioModel(
                    "Titulo",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
                )
            )
            list.add(
                PaginaGrimorioModel(
                    "Titulo",
                    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."
                )
            )
            //endregion

            return list
        }
    }

}