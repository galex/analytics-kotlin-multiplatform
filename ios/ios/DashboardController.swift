//
//  SecondViewController.swift
//  ios
//
//  Created by Alexandre Gherschon on 14/03/2019.
//  Copyright © 2019 Alexandre Gherschon. All rights reserved.
//

import UIKit
import Analytics

class SecondViewController: UIViewController {

    private let eventsHelper: EventsHelper = EventsHelper()
    
    override func viewDidAppear(_ animated: Bool) {
        EventsHelper().enterScreen(screen: Screen.dashboard)
    }
    
    override func viewDidDisappear(_ animated: Bool) {
        EventsHelper().exitScreen(screen: Screen.dashboard)
    }
}
