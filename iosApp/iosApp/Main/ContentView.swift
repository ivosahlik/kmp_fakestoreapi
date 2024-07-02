import SwiftUI

struct ContentView: View {
    @StateObject
    var viewModel = HomeViewModel()

    var body: some View {
        VStack {
            if viewModel.response?.isSuccess() == true {
                List(viewModel.response?.getProducts().items ?? [], id: \.id) { product in
                    ProductView(product: product)
                }
            } else if viewModel.response?.isError() == true {
                VStack {
                    Spacer()
                    Text("\(viewModel.response?.getErrorMessage() ?? "Unknown Error")")
                        .font(.title3)
                        .fontWeight(.bold)
                    Spacer()
                }
                .frame(maxWidth: .infinity, maxHeight: .infinity)
            } else if viewModel.response?.isLoading() == true {
                VStack {
                    Spacer()
                    ProgressView("Loading")
                        .progressViewStyle(CircularProgressViewStyle())
                        .padding()
                    Spacer()
                }
                .frame(maxWidth: .infinity, maxHeight: .infinity)
            }
        }.task {
            await viewModel.fetchData()
        }
    }
}
