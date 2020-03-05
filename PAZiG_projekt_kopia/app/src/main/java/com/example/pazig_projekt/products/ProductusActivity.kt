package com.example.pazig_projekt.products

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.pazig_projekt.R
import kotlinx.android.synthetic.main.activity_productus.*

class ProductusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_productus)

        val products = ArrayList<Product>()

        products.add(
            Product(
                "Czekolada i kakao",
                "Zatrucie może doprowadzić nawet do śmierci.",
                R.drawable.ic_poison_24dp
            )
        )
        products.add(
            Product(
                "Winogrona i rodzynki",
                "Mogą stanowić zagrożenia dla zdrowia i życia psa.",
                R.drawable.ic_poison_24dp
            )
        )
        products.add(
            Product(
                "Cebula i szczypiorek",
                "Po zatruciu może dojść do niedokrwistości, a jej skutkiem może być niewydolność nerek.",
                R.drawable.ic_poison_24dp
            )
        )
        products.add(
            Product(
                "Czosnek",
                "Po zatruciu może dojść do niedokrwistości, mogą wystąpić również objawy skórne.",
                R.drawable.ic_poison_24dp
            )
        )
        products.add(
            Product(
                "Pestki owoców i warzyw",
                "Niebezpieczne dla życia i zdrowia.",
                R.drawable.ic_poison_24dp
            )
        )
        products.add(
            Product(
                "Awokado",
                "Niebezpieczna nie jest sama roślina, a środek stosowany w jej uprwie. Powoduje biegunkę i wymioty.",
                R.drawable.ic_poison_24dp
            )
        )
        products.add(
            Product(
                "Orzechy",
                "Większość niepolecana dla psów, po zjedzeniu orzechów makadamia mogą wystąpić wymioty, drgawki, biegunka.",
                R.drawable.ic_poison_24dp
            )
        )

        products.add(
            Product(
                "Mięso",
                "Najlepiej podawać różne rodzaje mięsa (wieprzowe, wołowe, z królika itd.), aby dostarczyć wszystkich potrzebnych aminokwasów. Wbrew pozorom najlepsze będzie te z widocznymi przerostami tkanki łącznej i tłuszczu.",
                R.drawable.ic_smiley_24dp
            )
        )
        products.add(
            Product(
                "Jajka",
                "Białko jaja należy podawać ugotowane, nieugotowane zaburza wchłanianie witamin! Jakościowo najlepsze białko, zawiera wszystkie potrzebne aminokwasy w odpowiednich proporcjach.",
                R.drawable.ic_smiley_24dp
            )
        )
        products.add(
            Product(
                "Ryby",
                "W diecie domowej należy wprowadzić ryby jako źródło kwasów omega 3 oraz witaminy A i D. Należy uważać na ości.",
                R.drawable.ic_smiley_24dp
            )
        )
        products.add(
            Product(
                "Podroby",
                "Są dobrym składnikiem diety, można je podawać bez obaw.",
                R.drawable.ic_smiley_24dp
            )
        )
        products.add(
            Product(
                "Warzywa",
                "Są ważnym, a często pomijanym składnikiem psiej diety, są cennym źródłem witamin. Warzywa takie jak sałata i kapusta w większej ilości mogą wywołać biegunkę. Nie podawać cebuli i czosnku, są toksyczne.",
                R.drawable.ic_smiley_24dp
            )
        )
        products.add(
            Product(
                "Owoce",
                "Dostarczają niezbędnych witamin. Należy podawać ich znacznie mniej niż warzyw ze względu na dużą zawartość fruktozy. Z owoców nie powinno się podawać cytrusów i awokado.",
                R.drawable.ic_smiley_24dp
            )
        )
        products.add(
            Product(
                "Oleje roślinne",
                "Olej lniany i oliwa dostarczają kwasów omega 3, a olej słonecznikowy, rzepakowy i krokoszowy kwasów omega 6. Powinno się je uwzględnić w diecie, ale w małych ilościach przez ich dużą kaloryczność.",
                R.drawable.ic_smiley_24dp
            )
        )
        products.add(
            Product(
                "Ryż",
                "Jest dobrym źródłem węglowodanów, psy bardzo dobrze go trawią. Należy go jednak traktować głównie jako wypełniacz. Lepiej podawać ryż brązowy niż biały.",
                R.drawable.ic_smiley_24dp
            )
        )
        products.add(
            Product(
                "Makaron",
                "Może być stosowany jako wypełniacz podobnie jak ryż, należy jednak pamiętać o jego dużej kaloryczności. Lepiej podawać makaron pełnoziarnisty jeżeli jest trawiony przez psa.",
                R.drawable.ic_smiley_24dp
            )
        )

        products.add(
            Product(
                "Ziemniaki",
                "Ugotowane mogą być stosowane jako wypełniacz, ale są dość ciężko strawne i nie należy podawać ich dużo.",
                R.drawable.ic_neutral_24dp
            )
        )
        products.add(
            Product(
                "Ser biały, jogurt naturalny, kefir",
                "Są dobrym źródłem białka i łatwowchłanialnych składników mineralnych. Jeżeli pies nie jadł do tej pory produktów mlecznych należy je wprowadzać ostrożnie, część psów nie toleruje laktozy.",
                R.drawable.ic_neutral_24dp
            )
        )
        products.add(
            Product(
                "Ser żółty",
                "Korzystny w małych ilościach jako przysmak jeżeli pies toleruje laktozę.",
                R.drawable.ic_neutral_24dp
            )
        )

        products.add(
            Product(
                "Słodycze",
                "Nie należy podawać psu słodyczy. Zwłaszcza, że część z nich zawiera toksyczną dla psa czekoladę.",
                R.drawable.ic_sad_24dp
            )
        )
        products.add(
            Product(
                "Kości",
                "Podawanie psu kości jest dyskusyjne z tego względu, że twarde odłamki mogą uszkodzić przewód pokarmowy. Po zjedzeniu kości często dochodzi do zaparć, a w skrajnych przypadkach zaczopowania przewodu pokarmowego.",
                R.drawable.ic_sad_24dp
            )
        )
        products.add(
            Product(
                "Przyprawy",
                "Duża część z nich może podrażnić przewód pokarmowy psa. Niektóre zioła można uwzględnić w diecie. Przed podaniem należy sprawdzić, czy konkretne zioło jest odpowiednie.",
                R.drawable.ic_sad_24dp
            )
        )
        products.add(
            Product(
                "Grzyby",
                "Nie należy podawać psom grzybów. Nawet te jadalne dla ludzi często nie są odpowiednie dla psów.",
                R.drawable.ic_sad_24dp
            )
        )
        products.add(
            Product(
                "Rośliny strączkowe",
                "Bardzo ciężko strawne.",
                R.drawable.ic_sad_24dp
            )
        )
        products.add(
            Product(
                "Kasze",
                "Bardzo ciężko strawne.",
                R.drawable.ic_sad_24dp
            )
        )

        rvProductList.layoutManager = LinearLayoutManager(this)

        val adapter = ProductsAdapter(products, this)
        rvProductList.adapter = adapter

    }
}
class Product (val productName : String, val productDescription : String, val productRecommendation :Int ){

}