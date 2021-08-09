package com.achdanepiloksa.belajar_layouting.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.achdanepiloksa.belajar_layouting.R
import com.achdanepiloksa.belajar_layouting.form.FormActivity
import com.achdanepiloksa.belajar_layouting.home.model.Model
import kotlinx.android.synthetic.main.activity_form.*
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    companion object{
        const val LAUNCH_FORM_ACTIVITY = 1
    }

    private lateinit var adapter: Adapter


    private var pokemons = mutableListOf<Model>(
        Model(
            "Pikachu",
            "https://images-na.ssl-images-amazon.com/images/I/61iWqqcq%2BKL._AC_SL1500_.jpg"
        ),
        Model(
            "Bulbasaur",
            "https://miro.medium.com/max/1936/1*3vmrvcM-fZzHAmksjf7kAg.png"
        ),
        Model(
            "Charizard",
             "https://assets.pokemon.com/assets/cms2/img/pokedex/full/006_f3.png"
        ),
        Model(
            "Palkia",
            "https://static.pokemonpets.com/images/monsters-images-800-800/2484-Shiny-Palkia.png"
        ),
        Model(
            "Dialga",
            "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/37268c81-dce3-44a4-9064-5001138eb2d9/dcxcjba-23a81684-da35-409f-ad07-53d7ca4c5f92.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3sicGF0aCI6IlwvZlwvMzcyNjhjODEtZGNlMy00NGE0LTkwNjQtNTAwMTEzOGViMmQ5XC9kY3hjamJhLTIzYTgxNjg0LWRhMzUtNDA5Zi1hZDA3LTUzZDdjYTRjNWY5Mi5wbmcifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6ZmlsZS5kb3dubG9hZCJdfQ.V98zx0wbNO8iY5MSDPBGtaA7azpkgcc3wpjGJWplzgA"
        ),
        Model(
            "Giratina",
            "https://gamepress.gg/pokemongo/sites/pokemongo/files/2018-02/487Giratina-Altered.png"
        ),
        Model(
            "Latias",
            "https://i.pinimg.com/originals/cd/82/aa/cd82aa5463914621836178cf722777e8.png"
        ),
        Model(
            "Latios",
            "https://images-na.ssl-images-amazon.com/images/I/61iWqqcq%2BKL._AC_SL1500_.jpg"
        ),
        Model(
            "Snorlax",
            "https://miro.medium.com/max/1936/1*3vmrvcM-fZzHAmksjf7kAg.png"
        ),
        Model(
            "Hehe",
            "https://pngimage.net/wp-content/uploads/2018/06/%D0%B4%D0%B6%D0%B5%D1%80%D1%80%D0%B8-%D0%BC%D0%B5%D0%BC-png-.png"
        )
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       this.adapter = Adapter(this.pokemons)
        rv_pokemon.adapter = this.adapter
        rv_pokemon.layoutManager = LinearLayoutManager(this)

        btn_addpokemon.setOnClickListener{
            val intent = Intent(this, FormActivity::class.java)
            startActivityForResult(intent,MainActivity.LAUNCH_FORM_ACTIVITY)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == LAUNCH_FORM_ACTIVITY){
            val newName = data?.getStringExtra("name")
            val newURL = data?.getStringExtra("url")

            val newPokemon = Model(newName?:"", newURL?:"")
            this.pokemons.add(newPokemon)

            this.adapter.notifyItemInserted(this.pokemons.size-1)
        }
    }
}