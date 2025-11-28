@file:Suppress("ktlint:standard:no-wildcard-imports")

package com.dessalines.thumbkey.keyboards

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowDropDown
import androidx.compose.material.icons.outlined.ArrowDropUp
import com.dessalines.thumbkey.utils.*
import com.dessalines.thumbkey.utils.ColorVariant.*
import com.dessalines.thumbkey.utils.FontSizeVariant.*
import com.dessalines.thumbkey.utils.KeyAction.*
import com.dessalines.thumbkey.utils.SwipeNWay.*

/**
 * English "Sidecar" 3x6 layout.
 *
 * Grid:
 * Row 0: emoji , o , e , backspace, s, n
 * Row 1: [shift ctrl] , i , t, space, a, d
 * Row 2: num, r, u, enter, h, l
 *
 * - Leftmost column is all control keys (emoji / shift / numeric).
 * - Swipes are inward-focused; no need to swipe off the screen edges.
 * - Letter swipes largely mirror Hyper-Space patterns, with adjustments.
 */

// Local copies of emoji / numeric keys without directional swipes
private val SIDECAR_EMOJI_KEY_ITEM =
    KeyItemC(
        center = EMOJI_KEY_ITEM.center,
    )

private val SIDECAR_NUMERIC_KEY_ITEM =
    KeyItemC(
        center = NUMERIC_KEY_ITEM.center,
    )

val KB_EN_SIDECAR_3X6_MAIN =
    KeyboardC(
        listOf(
            // Row 0: emoji , o , e , backspace, s, n
            listOf(
                // Leftmost: emoji control key (no swipes)
                SIDECAR_EMOJI_KEY_ITEM,

                // 'o' key: letter + shift control + 'k' swipe
                KeyItemC(
                    center = KeyC("o", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    // Up swipe = enable shift (Hyper-Space style)
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
                    // Right swipe = 'k'
                    right = KeyC("k"),
                ),

                // 'e' key with punctuation (from Hyper-Space)
                KeyItemC(
                    center = KeyC("e", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    left = KeyC(".", color = MUTED),
                    top = KeyC(",", color = MUTED),
                    bottom = KeyC("?", color = MUTED),
                ),

                // Backspace control key
                BACKSPACE_KEY_ITEM,

                // 's' key with c/q/- swipes (from Hyper-Space)
                KeyItemC(
                    center = KeyC("s", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    left = KeyC("c"),
                    bottom = KeyC("q"),
                    top = KeyC("-", color = MUTED),
                ),

                // 'n' key: inward swipes only, now giving 'b' (down)
                KeyItemC(
                    center = KeyC("n", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    // Right swipe removed (was 'b', off-screen)
                    bottom = KeyC("b"),
                ),
            ),

            // Row 1: [shift ctrl] , i , t, space, a, d
            listOf(
                // Left column: dedicated shift control (no left swipe)
                KeyItemC(
                    center =
                        KeyC(
                            display = KeyDisplay.IconDisplay(Icons.Outlined.ArrowDropUp),
                            action = ToggleShiftMode(true),
                            swipeReturnAction = ToggleCurrentWordCapitalization(true),
                            color = MUTED, // grey control key
                        ),
                    bottom =
                        KeyC(
                            display = KeyDisplay.IconDisplay(Icons.Outlined.ArrowDropDown),
                            action = ToggleShiftMode(false),
                            swipeReturnAction = ToggleCurrentWordCapitalization(false),
                            color = MUTED,
                        ),
                ),

                // 'i' key with ' and ; and now 'g' (right) for inward swipe
                KeyItemC(
                    center = KeyC("i", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    top = KeyC("'", color = MUTED),
                    left = KeyC(";", color = MUTED),
                    right = KeyC("g"),
                ),

                // 't' key with p/w/m and now 'z' on left (inwards)
                KeyItemC(
                    center = KeyC("t", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    right = KeyC("p"),
                    bottom = KeyC("w"),
                    top = KeyC("m"),
                    left = KeyC("z"),
                ),

                // Spacebar
                SPACEBAR_SKINNY_KEY_ITEM,

                // 'a' key with j and ! (from Hyper-Space)
                KeyItemC(
                    center = KeyC("a", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    left = KeyC("j"),
                    bottom = KeyC("!", color = MUTED),
                ),

                // 'd' plain (no swipe; 'd' removed from 'n')
                KeyItemC(
                    center = KeyC("d", size = LARGE),
                ),
            ),

            // Row 2: num, r, u, enter, h, l
            listOf(
                // Left column: numeric control key (no swipes)
                SIDECAR_NUMERIC_KEY_ITEM,

                // 'r' key with / and # (unchanged)
                KeyItemC(
                    center = KeyC("r", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    left = KeyC("/", color = MUTED),
                    top = KeyC("#", color = MUTED),
                ),

                // 'u' key: inward x on TOP now, ` on right
                KeyItemC(
                    center = KeyC("u", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    right = KeyC("`", color = MUTED),
                    top = KeyC("x"),
                ),

                // Enter/return control key
                RETURN_KEY_ITEM,

                // 'h' key with f and v (from Hyper-Space)
                KeyItemC(
                    center = KeyC("h", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    right = KeyC("f"),
                    top = KeyC("v"),
                ),

                // 'l' key: 'y' is now inward (left), '@' moved to top
                KeyItemC(
                    center = KeyC("l", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    left = KeyC("y"),
                    top = KeyC("@", color = MUTED),
                ),
            ),
        ),
    )

val KB_EN_SIDECAR_3X6_SHIFTED =
    KeyboardC(
        listOf(
            // Row 0: emoji , O , E , backspace, S, N
            listOf(
                SIDECAR_EMOJI_KEY_ITEM,

                // 'O' key: just letter + 'K' swipe (no caps/capslock)
                KeyItemC(
                    center = KeyC("O", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    right = KeyC("K"),
                ),

                KeyItemC(
                    center = KeyC("E", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    left = KeyC(".", color = MUTED),
                    top = KeyC(",", color = MUTED),
                    bottom = KeyC("?", color = MUTED),
                ),

                BACKSPACE_KEY_ITEM,

                KeyItemC(
                    center = KeyC("S", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    left = KeyC("C"),
                    bottom = KeyC("Q"),
                    top = KeyC("_", color = MUTED),
                ),

                KeyItemC(
                    center = KeyC("N", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    bottom = KeyC("B"),
                ),
            ),

            // Row 1: [shift ctrl] , I , T, space, A, D
            listOf(
                // Same shift control behaviour as main; explicitly grey
                KeyItemC(
                    center =
                        KeyC(
                            display = KeyDisplay.IconDisplay(Icons.Outlined.ArrowDropUp),
                            action = ToggleShiftMode(true),
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
                    center = KeyC("I", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    top = KeyC("'", color = MUTED),
                    left = KeyC(";", color = MUTED),
                    right = KeyC("G"),
                ),

                KeyItemC(
                    center = KeyC("T", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    right = KeyC("P"),
                    bottom = KeyC("W"),
                    top = KeyC("M"),
                    left = KeyC("Z"),
                ),

                SPACEBAR_SKINNY_KEY_ITEM,

                KeyItemC(
                    center = KeyC("A", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    left = KeyC("J"),
                    bottom = KeyC("!", color = MUTED),
                ),

                KeyItemC(
                    center = KeyC("D", size = LARGE),
                ),
            ),

            // Row 2: num, R, U, enter, H, L
            listOf(
                SIDECAR_NUMERIC_KEY_ITEM,

                KeyItemC(
                    center = KeyC("R", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    left = KeyC("/", color = MUTED),
                    top = KeyC("#", color = MUTED),
                ),

                KeyItemC(
                    center = KeyC("U", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    right = KeyC("~", color = MUTED),
                    top = KeyC("X"),
                ),

                RETURN_KEY_ITEM,

                KeyItemC(
                    center = KeyC("H", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    right = KeyC("F"),
                    top = KeyC("V"),
                ),

                KeyItemC(
                    center = KeyC("L", size = LARGE),
                    swipeType = FOUR_WAY_CROSS,
                    left = KeyC("Y"),
                    top = KeyC("@", color = MUTED),
                ),
            ),
        ),
    )

val KB_EN_SIDECAR_3X6: KeyboardDefinition =
    KeyboardDefinition(
        title = "english sidecar 3x6",
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
