package com.by.westik.google.codelab.myapplication

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorTest {

    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    /*
        Функция onView()принимает ViewMatcher параметр объекта.
        По сути, A ViewMatcher— это компонент пользовательского интерфейса, который соответствует определенным критериям,
         в данном случае это компонент с идентификатором R.id.cost_of_service_edit_text
     */

    @Test
    fun calculate_20_percent_tip() {
        /*
        Функция withId()возвращает ViewMatcher компонент пользовательского интерфейса с
        переданным ему идентификатором
         */

        /*
        onView()возвращает ViewInteractio nобъект, с которым мы можем взаимодействовать, как если
         бы мы сами управляли устройством.
        Чтобы ввести текст, вы вызываете perform()функцию ViewInteraction. Затем perform()берет
        ViewAction предмет
         */

        // ввод цены заказа
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("50.00"))
            .perform(ViewActions.closeSoftKeyboard()) // закрытие клавиатуры

        // нажатие кнопки "Рассчитать"
        onView(withId(R.id.calculate_button))
            .perform(click())

        // проверка правильного отображения цены заказа
        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("10,00 ₽"))))

    }

}