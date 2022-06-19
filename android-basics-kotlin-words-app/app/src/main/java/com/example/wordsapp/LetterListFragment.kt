/*
 * Copyright (C) 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.wordsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.databinding.FragmentLetterListBinding

/**
 * Entry fragment for the app. Displays a [RecyclerView] of letters.
 */
class LetterListFragment : Fragment() {
    private var _binding: FragmentLetterListBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    //在 binding 屬性下方，建立回收業者檢視畫面的屬性。
    private lateinit var recyclerView: RecyclerView
    // Keeps track of which LayoutManager is in use for the [RecyclerView]
    private var isLinearLayoutManager = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 若要顯示選項選單，請覆寫呼叫 setHasOptionsMenu() 的
        // onCreate() 內的 onCreate(). 以傳入 true。
        setHasOptionsMenu(true)
    }

    //請記住，如果使用片段，會在 onCreateView()
    // 中加載版面配置。加載檢視畫面、設定_binding 的值
    // ，並傳回根層級檢視畫面，就可導入 onCreateView()。
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Retrieve and inflate the layout for this fragment
        _binding = FragmentLetterListBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    //然後在 onViewCreated() 中設定 recyclerView 屬性的值，並呼叫 chooseLayout()，
    // 就像您在 MainActivity 中的方式一樣。您很快將 chooseLayout() 方法移到
    // LetterListFragment，所以不需要擔心會有錯誤。
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //請注意，繫結類別已經建立 recyclerView 的屬性，
        // 因此您不需要針對每個檢視畫面呼叫 findViewById()。
        recyclerView = binding.recyclerView
        // Sets the LayoutManager of the recyclerview
        // On the first run of the app, it will be LinearLayoutManager
        chooseLayout()
    }

    /**
     * Frees the binding object when the Fragment is destroyed.
     */
    override fun onDestroyView() {
        super.onDestroyView()
        //最後在 onDestroyView() 中，將 _binding 屬性重設為 null，因為檢視畫面已不存在。
        _binding = null
    }

    //另外也請注意，使用片段時，onCreateOptionsMenu() 方法有些微的差異。雖然 Activity
    // 類別具有名為 menuInflater 的全域屬性，但 Fragment 沒有此屬性。
    // 而是將選單 inflater 傳遞至 onCreateOptionsMenu() 中。
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.layout_menu, menu)

        val layoutButton = menu.findItem(R.id.action_switch_layout)
        setIcon(layoutButton)
    }

    /**
     * Sets the LayoutManager for the [RecyclerView] based on the desired orientation of the list.
     *
     * Notice that because the enclosing class has changed from an Activity to a Fragment,
     * the signature of the LayoutManagers has to slightly change.
     */

    //將 chooseLayout()、setIcon() 和 onOptionsItemSelected()
    // 的其餘程式碼按原樣移動至 MainActivity。應注意的唯一差別在於，
    // 與活動不同，片段不是 Context。您無法透過 this (參照片段物件)
    // 作為版面配置管理員的結構定義。但是，片段會提供 context 屬性，
    // 您可以改用該屬性。程式碼的其餘部分與 MainActivity 相同。
    private fun chooseLayout() {
        if (isLinearLayoutManager) {
            recyclerView.layoutManager = LinearLayoutManager(context)
        } else {
            recyclerView.layoutManager = GridLayoutManager(context, 4)
        }
        recyclerView.adapter = LetterAdapter()
    }

    private fun setIcon(menuItem: MenuItem?) {
        if (menuItem == null)
            return

        menuItem.icon =
            if (isLinearLayoutManager)
                ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_grid_layout)
            else ContextCompat.getDrawable(this.requireContext(), R.drawable.ic_linear_layout)
    }

    /**
     * Determines how to handle interactions with the selected [MenuItem]
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_switch_layout -> {
                // Sets isLinearLayoutManager (a Boolean) to the opposite value
                isLinearLayoutManager = !isLinearLayoutManager
                // Sets layout and icon
                chooseLayout()
                setIcon(item)

                return true
            }
            // Otherwise, do nothing and use the core event handling

            // when clauses require that all possible paths be accounted for explicitly,
            // for instance both the true and false cases if the value is a Boolean,
            // or an else to catch all unhandled cases.
            else -> super.onOptionsItemSelected(item)
        }
    }
}
