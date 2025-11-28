@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.dessalines.thumbkey.keyboards

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.ArrowDropUp
import androidx.compose.material.icons.outlined.KeyboardCapslock
import com.dessalines.thumbkey.utils.*
import com.dessalines.thumbkey.utils.ColorVariant.*
import com.dessalines.thumbkey.utils.FontSizeVariant.*
import com.dessalines.thumbkey.utils.KeyAction.*
import com.dessalines.thumbkey.utils.SwipeNWay.*

/**
 * English "Sidecar" 3x6 layout:
 *
 * Row 0: emoji , o , e , backspace, s, n
 * Row 1: ? , i , t, space, a, d
 * Row 2: num, r, u, enter, h, l
 *
 * 3 rows x 6 columns total, no separate bottom row.
 */

val KB_EN_SIDECAR_3X6_MAIN =
    KeyboardC(
        listOf(
            // Row 0: emoji , o , e , backspace, s, n
            listOf(
                EMOJI_KEY_ITEM,
                KeyItemC(
                    center = KeyC("o", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    // Up swipe = enable shift (pattern borrowed from Hyper-Space "o" key)
                    top =
                        KeyC(
                            display = KeyDisplay.IconDisplay(Icons.Outlined.ArrowDropUp),
                            action = ToggleShiftMode(true),
                            swipeReturnAction = ToggleCurrentWordCapitalization(true),
                            color = MUTED,
                        ),
                    // Down swipe = disable shift
                    bottom =
                        KeyC(
                            ToggleShiftMode(false),
                            swipeReturnAction = ToggleCurrentWordCapitalization(false),
                        ),
                ),
                KeyItemC(
                    center = KeyC("e", size = LARGE),
                ),
                BACKSPACE_KEY_ITEM,
                KeyItemC(
                    center = KeyC("s", size = LARGE),
                ),
                KeyItemC(
                    center = KeyC("n", size = LARGE),
                ),
            ),

            // Row 1: ? , i , t, space, a, d
            listOf(
                KeyItemC(
                    center = KeyC("?", size = LARGE),
                ),
                KeyItemC(
                    center = KeyC("i", size = LARGE),
                ),
                KeyItemC(
                    center = KeyC("t", size = LARGE),
                ),
                SPACEBAR_SKINNY_KEY_ITEM,
                KeyItemC(
                    center = KeyC("a", size = LARGE),
                ),
                KeyItemC(
                    center = KeyC("d", size = LARGE),
                ),
            ),

            // Row 2: num, r, u, enter, h, l
            listOf(
                NUMERIC_KEY_ITEM,
                KeyItemC(
                    center = KeyC("r", size = LARGE),
                ),
                KeyItemC(
                    center = KeyC("u", size = LARGE),
                ),
                RETURN_KEY_ITEM,
                KeyItemC(
                    center = KeyC("h", size = LARGE),
                ),
                KeyItemC(
                    center = KeyC("l", size = LARGE),
                ),
            ),
        ),
    )

val KB_EN_SIDECAR_3X6_SHIFTED =
    KeyboardC(
        listOf(
            // Row 0: emoji , O , E , backspace, S, N
            listOf(
                EMOJI_KEY_ITEM,
                KeyItemC(
                    center = KeyC("O", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    // In shifted mode, act as Caps Lock / Shift toggle (like Hyper-Space)
                    top =
                        KeyC(
                            display = KeyDisplay.IconDisplay(Icons.Outlined.KeyboardCapslock),
                            capsModeDisplay = KeyDisplay.IconDisplay(Icons.Outlined.ArrowDropUp),
                            action = ToggleCapsLock,
                            swipeReturnAction = ToggleCurrentWordCapitalization(true),
                            color = MUTED,
                        ),
                    bottom =
                        KeyC(
                            display = KeyDisplay.IconDisplay(Icons.Outlined.ArrowDropDown),
                            action = ToggleShiftMode(false),
                            swipeReturnAction = ToggleCurrentWordCapitalization(false),
                            color = MUTED,
                        ),
                ),
                KeyItemC(
                    center = KeyC("E", size = LARGE),
                ),
                BACKSPACE_KEY_ITEM,
                KeyItemC(
                    center = KeyC("S", size = LARGE),
                ),
                KeyItemC(
                    center = KeyC("N", size = LARGE),
                ),
            ),

            // Row 1: ? , I , T, space, A, D
            listOf(
                KeyItemC(
                    center = KeyC("?", size = LARGE),
                ),
                KeyItemC(
                    center = KeyC("I", size = LARGE),
                ),
                KeyItemC(
                    center = KeyC("T", size = LARGE),
                ),
                SPACEBAR_SKINNY_KEY_ITEM,
                KeyItemC(
                    center = KeyC("A", size = LARGE),
                ),
                KeyItemC(
                    center = KeyC("D", size = LARGE),
                ),
            ),

            // Row 2: num, R, U, enter, H, L
            listOf(
                NUMERIC_KEY_ITEM,
                KeyItemC(
                    center = KeyC("R", size = LARGE),
                ),
                KeyItemC(
                    center = KeyC("U", size = LARGE),
                ),
                RETURN_KEY_ITEM,
                KeyItemC(
                    center = KeyC("H", size = LARGE),
                ),
                KeyItemC(
                    center = KeyC("L", size = LARGE),
                ),
            ),
        ),
    )

val KB_EN_SIDECAR_3X6: KeyboardDefinition =
    KeyboardDefinition(
        title = "english sidecar",
        modes =
            KeyboardDefinitionModes(
                main = KB_EN_SIDECAR_3X6_MAIN,
                shifted = KB_EN_SIDECAR_3X6_SHIFTED,
                numeric = HYPER_NUMERIC_KEYBOARD, // reuse Hyper-Space's numeric layout
            ),
        settings =
            KeyboardDefinitionSettings(
                autoCapitalizers = arrayOf(::autoCapitalizeI, ::autoCapitalizeIApostrophe),
            ),
    )
