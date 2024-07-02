//
//  HomeViewModel.swift
//  iosApp
//
//  Created by Ivo Vosahlik on 02.07.2024.
//  Copyright © 2024 orgName. All rights reserved.
//

import Foundation
import SwiftUI
import shared

class HomeViewModel: ObservableObject {
    
    @Published
    private(set) var response: RequestState? = nil
    
    @MainActor
    func fetchData() async {
        for await requestState in ProductsApi().fetchProducts(limit: 10) {
            response = requestState
        }
    }
}
