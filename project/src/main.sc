theme: /

    state: newNode_0
        a:  Добро пожаловать в грантовый модуль!
            Меня зовут Юнаша, я помогу подать заявку на грант.
        go!: /newNode_9

    state: newNode_9
        InputText:
            actions = [{"buttons":[{"name":"Задать вопрос","transition":"/newNode_41"}],"type":"buttons"}]
            prompt = Напишите, как к Вам удобно обращаться
            varName = name
            html = Напишите, как к Вам удобно обращаться
            htmlEnabled = false
            then = /newNode_5

    state: newNode_5
        a: Есть ли у Вас добавленный проект?
        go!: /newNode_6
    @IntentGroup
        {
          "boundsTo" : "/newNode_5",
          "actions" : [ {
            "buttons" : [ ],
            "type" : "buttons"
          } ],
          "global" : false
        }
    state: newNode_6
        state: 1
            intent: /sys/aimylogic/ru/agreement
            intent: /newNode_6/1

            go!: /newNode_4

        state: 2
            intent: /sys/aimylogic/ru/negation
            intent: /newNode_6/2

            go!: /newNode_40
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_6",
                name: "newNode_6 buttons",
                handler: function($context) {
                }
            });

    state: newNode_34
        a: Что-то пошло не так
        # Transition /newNode_45
        go!: /newNode_43
    @IntentGroup
        {
          "boundsTo" : "",
          "actions" : [ {
            "buttons" : [ ],
            "type" : "buttons"
          } ],
          "global" : true
        }
    state: newNode_35
        state: 1
            intent!: /newNode_35/1

            go!: /newNode_0

        state: 2
            intent!: /newNode_35/2

            go!: /newNode_41
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_35",
                name: "newNode_35 buttons",
                handler: function($context) {
                }
            });

    state: newNode_41
        a:  Если есть какие-нибудь вопросы обращайтесь.
            Можете указать любой раздел сайта и я про консультирую по нему
        go!: /newNode_48
    @IntentGroup
        {
          "boundsTo" : "/newNode_41",
          "actions" : [ {
            "buttons" : [ {
              "name" : "Перевод на оператора",
              "transition" : "/newNode_43"
            }, {
              "name" : "Позвонить",
              "transition" : "/newNode_47"
            }, {
              "name" : "Мероприятия",
              "transition" : "/newNode_8"
            }, {
              "name" : "Мои проекты",
              "transition" : ""
            } ],
            "type" : "buttons"
          } ],
          "global" : false
        }
    state: newNode_48
        state: 1
            intent: /newNode_48/1

            go!: /newNode_8

        state: 2
            intent: /newNode_48/2

            go!: /newNode_7
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_48",
                name: "newNode_48 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Перевод на оператора"
                    , transition: "/newNode_43"
                    },
                    {text: "Позвонить"
                    , transition: "/newNode_47"
                    },
                    {text: "Мероприятия"
                    , transition: "/newNode_8"
                    },
                    {text: "Мои проекты"
                    },
                  ]);
                }
            });

    state: newNode_43
        TransferToOperator:
            titleOfCloseButton = Переключить на бота
            messageBeforeTransfer = Вы будете переведены на оператора
            messageBeforeTransferHtml = Вы будете переведены на оператора
            ignoreOffline = true
            messageForWaitingOperator = Вам ответит первый освободившийся оператор
            messageForWaitingOperatorHtml = Вам ответит первый освободившийся оператор
            dialogCompletedState = /newNode_41
            sendMessagesToOperator = true
            sendMessageHistoryAmount = 5
            htmlEnabled = false
            destination = 

    state: newNode_47
        a: Для консультации позвоните +74953083103 || html = "Для консультации позвоните +74953083103", htmlEnabled = true
        script:
            $reactions.timeout({interval: _.template('15 seconds', {variable: '$session'})($session), targetState: '/newNode_41'});

    state: newNode_4
        a: Это очень здорово, я помогу оформить заявку
        # Transition /newNode_10
        go!: /newNode_8

    state: newNode_8
        a: Перейдите во вкладку мероприятия
        image: https://248305.selcdn.ru/zfl_prod/249774977/249774976/8zLzd8smm5Mu8ZdW.jpg
        a: Следующие шаги уже более трудные, пишите мне после каждого из них
        go!: /newNode_11
    @IntentGroup
        {
          "boundsTo" : "/newNode_8",
          "actions" : [ {
            "buttons" : [ {
              "name" : "Далее",
              "transition" : "/newNode_12"
            } ],
            "type" : "buttons"
          } ],
          "global" : false
        }
    state: newNode_11
        state: 1
            intent: /sys/aimylogic/ru/agreement
            intent: /newNode_11/1

            go!: /newNode_12
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_11",
                name: "newNode_11 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Далее"
                    , transition: "/newNode_12"
                    },
                  ]);
                }
            });

    state: newNode_12
        a: Выберите мероприятие, которое вам подходит
        go!: /newNode_13
    @IntentGroup
        {
          "boundsTo" : "/newNode_12",
          "actions" : [ {
            "buttons" : [ {
              "name" : "Далее",
              "transition" : "/newNode_24"
            }, {
              "name" : "Назад",
              "transition" : "/newNode_8"
            } ],
            "type" : "buttons"
          } ],
          "global" : false
        }
    state: newNode_13
        state: 1
            intent: /newNode_13/1

            go!: /newNode_24

        state: 2
            intent: /sys/aimylogic/ru/agreement

            go!: /newNode_24

        state: 3
            intent: /newNode_13/3

            go!: /newNode_8
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_13",
                name: "newNode_13 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Далее"
                    , transition: "/newNode_24"
                    },
                    {text: "Назад"
                    , transition: "/newNode_8"
                    },
                  ]);
                }
            });

    state: newNode_24
        a: Нажмите "Подать заявку"
        image: https://248305.selcdn.ru/zfl_prod/249774977/249774976/DjfvtA46gvPOFfYm.jpg
        go!: /newNode_25
    @IntentGroup
        {
          "boundsTo" : "/newNode_24",
          "actions" : [ {
            "buttons" : [ {
              "name" : "Далее",
              "transition" : "/newNode_26"
            }, {
              "name" : "Назад",
              "transition" : "/newNode_12"
            } ],
            "type" : "buttons"
          } ],
          "global" : false
        }
    state: newNode_25
        state: 1
            intent: /newNode_25/1

            go!: /newNode_26

        state: 2
            intent: /sys/aimylogic/ru/agreement

            go!: /newNode_26

        state: 3
            intent: /newNode_25/3

            go!: /newNode_12
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_25",
                name: "newNode_25 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Далее"
                    , transition: "/newNode_26"
                    },
                    {text: "Назад"
                    , transition: "/newNode_12"
                    },
                  ]);
                }
            });

    state: newNode_26
        a: Заполните все поля и нажмите "Сохранить"
        image: https://248305.selcdn.ru/zfl_prod/249774977/249774976/cJCxg0X8JHDI2spx.jpg
        go!: /newNode_27
    @IntentGroup
        {
          "boundsTo" : "/newNode_26",
          "actions" : [ {
            "buttons" : [ {
              "name" : "Далее",
              "transition" : "/newNode_29"
            }, {
              "name" : "Назад",
              "transition" : "/newNode_24"
            }, {
              "name" : "Документы для заполнения",
              "transition" : "/newNode_46"
            } ],
            "type" : "buttons"
          } ],
          "global" : false
        }
    state: newNode_27
        state: 1
            intent: /newNode_27/1

            go!: /newNode_29

        state: 2
            intent: /sys/aimylogic/ru/agreement

            go!: /newNode_29

        state: 3
            intent: /newNode_27/3

            go!: /newNode_46

        state: 4
            intent: /newNode_27/4

            go!: /newNode_24
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_27",
                name: "newNode_27 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Далее"
                    , transition: "/newNode_29"
                    },
                    {text: "Назад"
                    , transition: "/newNode_24"
                    },
                    {text: "Документы для заполнения"
                    , transition: "/newNode_46"
                    },
                  ]);
                }
            });

    state: newNode_29
        InputText:
            actions = [{"buttons":[],"type":"buttons"}]
            prompt = Введите адрес своей почты для напоминания о конце конкурса
            varName = emailto
            html = Введите адрес своей почты для напоминания о конце конкурса
            htmlEnabled = false
            then = /newNode_30

    state: newNode_30
        a: Хотели бы получать рассылку?
        go!: /newNode_32
    @IntentGroup
        {
          "boundsTo" : "/newNode_30",
          "actions" : [ {
            "buttons" : [ {
              "name" : "Да",
              "transition" : "/newNode_33"
            } ],
            "comments" : [ ],
            "nameLocator" : {
              "filename" : "src/convert.sc",
              "line" : 221,
              "col" : 9
            },
            "valueLocator" : {
              "filename" : "src/convert.sc",
              "line" : 221,
              "col" : 17
            },
            "type" : "buttons"
          } ],
          "global" : false
        }
    state: newNode_32
        state: 1
            intent: /sys/aimylogic/ru/agreement

            go!: /

        state: 2
            intent: /sys/aimylogic/ru/negation

            go!: /newNode_31
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_32",
                name: "newNode_32 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Да"
                    , transition: "/newNode_33"
                    },
                  ]);
                }
            });

    state: newNode_33
        HttpRequest:
            url = https://smsc.ru/sys/send.php?login=av2004&psw=MS1597530!&phones=${emailto}&mes=Поздравляем%20с%20удачной%20подачей%20заявки!&sender=alvoronin2015@yandex.ru&subj=Росмолодежь.Гранты&mail=1&fileurl=https://ambivert.club/wp-content/uploads/2019/03/ChEnnTeW4AEI2q9.jpg
            method = GET
            body = 
            okState = /newNode_31
            timeout = 0
            headers = []
            vars = []

    state: newNode_31
        GoogleSheets:
            operationType = writeDataToLine
            integrationId = 1dfb2bd3-d30c-4127-84e0-9d0021fd0283
            spreadsheetId = 1mbIceXY0ekAGwm3zdqi4SuU-T442A4NjmsLM1xcMkQg
            sheetName = Лист1
            body = {"values":["{{$session.name}}","{{$session.emailto}}"]}
            okState = /newNode_36
            errorState = /newNode_34

    state: newNode_36
        a: Успешно! Вам показать, как проверить статус заявки?
        go!: /newNode_37
    @IntentGroup
        {
          "boundsTo" : "/newNode_36",
          "actions" : [ {
            "buttons" : [ ],
            "type" : "buttons"
          } ],
          "global" : false
        }
    state: newNode_37
        state: 1
            intent: /sys/aimylogic/ru/agreement

            go!: /newNode_38

        state: 2
            intent: /sys/aimylogic/ru/negation

            go!: /newNode_41

        state: Fallback
            event: noMatch
            go!: /newNode_41
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_37",
                name: "newNode_37 buttons",
                handler: function($context) {
                }
            });

    state: newNode_38
        a: Перейдите во вкладку "Мои заявки"
        image: https://248305.selcdn.ru/zfl_prod/249774977/249774976/7MGLDPFAt4WJ0Uvh.png
        go!: /newNode_39
    @IntentGroup
        {
          "boundsTo" : "/newNode_38",
          "actions" : [ {
            "buttons" : [ {
              "name" : "Далее",
              "transition" : ""
            } ],
            "type" : "buttons"
          } ],
          "global" : false
        }
    state: newNode_39
        state: 1
            intent: /newNode_39/1

            go!: /newNode_41

        state: 2
            intent: /sys/aimylogic/ru/agreement

            go!: /newNode_41
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_39",
                name: "newNode_39 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Далее"
                    },
                  ]);
                }
            });

    state: newNode_40
        a: Ничего страшного, зайдите во вкладку Проект
        # Transition /newNode_42
        go!: /newNode_7

    state: newNode_7
        a: Нажмите "Добавить проект"
        image: https://248305.selcdn.ru/zfl_prod/249774977/249774976/ajyNX9t0bG61P6Ao.jpg
        a: Следующие шаги уже более трудные, пишите мне после каждого из них
        go!: /newNode_14
    @IntentGroup
        {
          "boundsTo" : "/newNode_7",
          "actions" : [ {
            "buttons" : [ {
              "name" : "Далее",
              "transition" : "/newNode_15"
            } ],
            "type" : "buttons"
          } ],
          "global" : false
        }
    state: newNode_14
        state: 1
            intent: /sys/aimylogic/ru/agreement

            go!: /newNode_15

        state: Fallback
            event: noMatch
            go!: /newNode_15
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_14",
                name: "newNode_14 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Далее"
                    , transition: "/newNode_15"
                    },
                  ]);
                }
            });

    state: newNode_15
        a: Выберите шаблон проекта
        image: https://248305.selcdn.ru/zfl_prod/249774977/249774976/X4bft9hd4asBScRK.jpg
        go!: /newNode_16
    @IntentGroup
        {
          "boundsTo" : "/newNode_15",
          "actions" : [ {
            "buttons" : [ {
              "name" : "Далее",
              "transition" : "/newNode_17"
            }, {
              "name" : "Назад",
              "transition" : "/newNode_7"
            } ],
            "type" : "buttons"
          } ],
          "global" : false
        }
    state: newNode_16
        state: 1
            intent: /newNode_16/1

            go!: /newNode_17

        state: 2
            intent: /sys/aimylogic/ru/agreement

            go!: /newNode_17

        state: 3
            intent: /newNode_16/3

            go!: /newNode_7
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_16",
                name: "newNode_16 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Далее"
                    , transition: "/newNode_17"
                    },
                    {text: "Назад"
                    , transition: "/newNode_7"
                    },
                  ]);
                }
            });

    state: newNode_17
        a: Заполните все разделы
        image: https://248305.selcdn.ru/zfl_prod/249774977/249774976/63pFdLICsqQnULQ5.jpg
        go!: /newNode_18
    @IntentGroup
        {
          "boundsTo" : "/newNode_17",
          "actions" : [ {
            "buttons" : [ {
              "name" : "Далее",
              "transition" : "/newNode_19"
            }, {
              "name" : "Назад",
              "transition" : "/newNode_15"
            }, {
              "name" : "Как заполнять?",
              "transition" : "/newNode_44"
            } ],
            "type" : "buttons"
          } ],
          "global" : false
        }
    state: newNode_18
        state: 1
            intent: /newNode_18/1

            go!: /newNode_19

        state: 2
            intent: /sys/aimylogic/ru/agreement

            go!: /newNode_19

        state: 3
            intent: /newNode_18/3

            go!: /newNode_44

        state: 4
            intent: /newNode_18/4

            go!: /newNode_15
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_18",
                name: "newNode_18 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Далее"
                    , transition: "/newNode_19"
                    },
                    {text: "Назад"
                    , transition: "/newNode_15"
                    },
                    {text: "Как заполнять?"
                    , transition: "/newNode_44"
                    },
                  ]);
                }
            });

    state: newNode_19
        a:  Нажмите "Сохранить как черновик", если хотите продолжить работу над проектом
            или
            Нажмите "Создать проект"
        image: https://248305.selcdn.ru/zfl_prod/249774977/249774976/DAkHBopo3HM6KLEj.jpg
        go!: /newNode_20
    @IntentGroup
        {
          "boundsTo" : "/newNode_19",
          "actions" : [ {
            "buttons" : [ {
              "name" : "Далее",
              "transition" : "/newNode_21"
            }, {
              "name" : "Назад",
              "transition" : "/newNode_17"
            } ],
            "type" : "buttons"
          } ],
          "global" : false
        }
    state: newNode_20
        state: 1
            intent: /newNode_20/1

            go!: /newNode_21

        state: 2
            intent: /sys/aimylogic/ru/agreement

            go!: /newNode_21

        state: 3
            intent: /newNode_20/3

            go!: /newNode_17
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_20",
                name: "newNode_20 buttons",
                handler: function($context) {
                  $reactions.buttons([
                    {text: "Далее"
                    , transition: "/newNode_21"
                    },
                    {text: "Назад"
                    , transition: "/newNode_17"
                    },
                  ]);
                }
            });

    state: newNode_21
        a: Будете подавать заявку на грант?
        go!: /newNode_22
    @IntentGroup
        {
          "boundsTo" : "/newNode_21",
          "actions" : [ {
            "buttons" : [ ],
            "type" : "buttons"
          } ],
          "global" : false
        }
    state: newNode_22
        state: 1
            intent: /sys/aimylogic/ru/agreement

            go!: /newNode_8

        state: 2
            intent: /sys/aimylogic/ru/negation

            go!: /newNode_41

        state: Fallback
            event: noMatch
            go!: /newNode_41
        init:
            $jsapi.bind({
                type: "postProcess",
                path: "/newNode_22",
                name: "newNode_22 buttons",
                handler: function($context) {
                }
            });

    state: newNode_46
        a: Все необходимые документы можно найти в Базе знаний || html = "Все необходимые документы можно найти в <a href=\"https://grants.myrosmol.ru/articles?type=file&amp;page=2\">Базе знаний</a>", htmlEnabled = true
        script:
            $reactions.timeout({interval: _.template('10 seconds', {variable: '$session'})($session), targetState: '/newNode_26'});

    state: newNode_44
        a: Следуйте методическим рекомендациям || html = "<a href=\"https://docs.yandex.ru/docs/view?url=ya-disk-public%3A%2F%2FaNUprn77OEdp7VTC1b%2FNO%2BJSMaHM13gLPFDSjkW6gCNdr5b9yq%2Bt2UnFjF%2BuxPw2DqZvSgIch5AN9ddz7ydViQ%3D%3D%3A%2FМетодические%20рекомендации%20участникам%20Росмолодежь.Гранты.pdf&amp;name=Методические%20рекомендации%20участникам%20Росмолодежь.Гранты.pdf&amp;nosw=1\">Следуйте методическим рекомендациям</a>", htmlEnabled = true
        script:
            $reactions.timeout({interval: _.template('10 seconds', {variable: '$session'})($session), targetState: '/newNode_17'});