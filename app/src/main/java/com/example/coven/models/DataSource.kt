package com.example.coven.models

import java.time.LocalDate
import java.util.*
import kotlin.collections.ArrayList

class DataSource {

    companion object{

        fun createDataSet(): ArrayList<EventoModel>{
            val list = ArrayList<EventoModel>()
            list.add(
                EventoModel(
                    "Sabrina",
                    "Conmemoración de Salem",
                    Date(2020, 5, 13),
                    "Todas las brujas están invitadas a la reunión convocada para recordar a nuestras hermanas juzgadas",
                    "Salem, Massachusetts"
                )
            )
            list.add(
                EventoModel(
                    "LadyNight",
                    "Meditación en Grupo",
                    Date(2020, 7, 13),
                    "Todos los hermanos nos uniremos para meditar",
                    "Casa de LadyNight"
                )
            )
            list.add(
                EventoModel(
                    "AnaValdes",
                    "Bailar en la hoguera",
                    Date(2020, 6, 13),
                    "La luna nueva se aproxima, dancemos para celebrar",
                    "Bosque"
                )
            )
            list.add(
                EventoModel(
                    "RisaSardonica",
                    "Llamado al Baphomet",
                    Date(2020, 10, 13),
                    "Vengan",
                    "Salem, Massachusetts"
                )
            )
            list.add(
                EventoModel(
                    "Sabrina",
                    "Conmemoración de Salem",
                    Date(2020, 5, 13),
                    "Todas las brujas están invitadas a la reunión convocada para recordar a nuestras hermanas juzgadas",
                    "Salem, Massachusetts"
                )
            )
            list.add(
                EventoModel(
                    "Sabrina",
                    "Conmemoración de Salem",
                    Date(2020, 5, 13),
                    "Todas las brujas están invitadas a la reunión convocada para recordar a nuestras hermanas juzgadas",
                    "Salem, Massachusetts"
                )
            )
            list.add(
                EventoModel(
                    "LadyNight",
                    "Meditación en Grupo",
                    Date(2020, 7, 13),
                    "Todos los hermanos nos uniremos para meditar",
                    "Casa de LadyNight"
                )
            )
            list.add(
                EventoModel(
                    "AnaValdes",
                    "Bailar en la hoguera",
                    Date(2020, 6, 13),
                    "La luna nueva se aproxima, dancemos para celebrar",
                    "Bosque"
                )
            )
            list.add(
                EventoModel(
                    "RisaSardonica",
                    "Llamado al Baphomet",
                    Date(2020, 10, 13),
                    "Vengan",
                    "Salem, Massachusetts"
                )
            )
            list.add(
                EventoModel(
                    "Sabrina",
                    "Conmemoración de Salem",
                    Date(2020, 5, 13),
                    "Todas las brujas están invitadas a la reunión convocada para recordar a nuestras hermanas juzgadas",
                    "Salem, Massachusetts"
                )
            )

            return list
        }

    }

}